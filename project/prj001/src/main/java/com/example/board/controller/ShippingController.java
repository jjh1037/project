package com.example.board.controller;


import com.example.board.dto.ShippingDto;
import com.example.board.mappers.ShippingMapper;
import com.example.board.service.ShippingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.UUID;

@Controller
@RequestMapping("/shipping")
public class ShippingController {

    @Autowired
    ShippingMapper shippingMapper;

    @Autowired
    ShippingService shippingService;

    @Value("${fileDir}")
    String fileDir;

   @GetMapping("/list")
    public String getList(Model model,
                          @RequestParam(value="searchType", defaultValue = "") String searchType,
                          @RequestParam(value="words", defaultValue = "") String words,
                          @RequestParam(value = "page", defaultValue = "1") int page) {

       model.addAttribute("cnt", shippingService.getSearchCnt(searchType, words));
       model.addAttribute("list", shippingService.getSearch(page, searchType, words));
       model.addAttribute("page", shippingService.shippingPageCalc(page));

       return "shipping/list";
   }

   @GetMapping("/write")
    public String getWrite() {
       return "shipping/write";
   }

   @PostMapping("/write")
    public String setWrite(@ModelAttribute ShippingDto shippingDto,
                           @RequestParam("file")MultipartFile mf) throws IOException {
        if( !mf.isEmpty() ) {
           String folderName = new SimpleDateFormat("yyyyMMdd").format(System.currentTimeMillis());
           File makeFolder = new File(fileDir + folderName);
           if( !makeFolder.exists() ) {
               makeFolder.mkdir();
           }

           String orgName = mf.getOriginalFilename();
           String ext = orgName.substring(orgName.lastIndexOf("."));
           String uuid = UUID.randomUUID().toString();
           String savedFileName = uuid + ext;
           String savedFilePathName = fileDir + folderName + "/" + savedFileName;

           shippingDto.setOrgName(orgName);
           shippingDto.setSavedFileName(savedFileName);
           shippingDto.setSavedFilePathName(savedFilePathName);
           shippingDto.setSavedFileSize(mf.getSize());
           shippingDto.setFolderName(folderName);
           shippingDto.setExt(ext);

           mf.transferTo( new File(savedFilePathName) );
        }

       shippingMapper.setWrite(shippingDto);
       return "redirect:/shipping/list";
   }

   @GetMapping("/view")
    public String getView(@RequestParam int id, Model model){

       model.addAttribute("view", shippingMapper.getView(id));
       return "shipping/view";
   }

   @GetMapping("/delete")
    public String setDelete(@RequestParam int id) {
       shippingService.setDelete(id);
       return "redirect:/shipping/list";
   }

   @GetMapping("/update")
    public String getUpdate(@RequestParam int id, Model model) {
        ShippingDto shippingDto = shippingMapper.getView(id);

        model.addAttribute("shipList", shippingDto);
        return "shipping/update";
   }

   @PostMapping("/update")
    public String setUpdate(@ModelAttribute ShippingDto shippingDto,
                            @RequestParam("file") MultipartFile mf) throws IOException {

       if( !mf.isEmpty() ) {
           String folderName = new SimpleDateFormat("yyyyMMdd").format(System.currentTimeMillis());
           File makeFolder = new File(fileDir + folderName);
           if( !makeFolder.exists() ) {
               makeFolder.mkdir();
           }

           String orgName = mf.getOriginalFilename();
           String ext = orgName.substring(orgName.lastIndexOf("."));
           String uuid = UUID.randomUUID().toString();
           String savedFileName = uuid + ext;
           String savedFilePathName = fileDir + folderName + "/" + savedFileName;

           shippingDto.setOrgName(orgName);
           shippingDto.setSavedFileName(savedFileName);
           shippingDto.setSavedFilePathName(savedFilePathName);
           shippingDto.setSavedFileSize(mf.getSize());
           shippingDto.setFolderName(folderName);
           shippingDto.setExt(ext);

           mf.transferTo( new File(savedFilePathName) );
       }else {
           // 값을 미변경시 원래값인 hidden에 있는 값을 저장
           // html hidden 값이 넘어온것
           // db      저장객체    html      hidden
           shippingDto.setOrgName(shippingDto.getOrgName());
           shippingDto.setSavedFileName(shippingDto.getSavedFileName());
           shippingDto.setSavedFilePathName(shippingDto.getSavedFilePathName());
           shippingDto.setSavedFileSize(shippingDto.getSavedFileSize());
           shippingDto.setFolderName(shippingDto.getFolderName());
           shippingDto.setExt(shippingDto.getExt());
       }

       shippingMapper.setUpdate(shippingDto);

       return "redirect:/shipping/list";
   }


}
