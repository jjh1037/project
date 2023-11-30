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
                          @RequestParam(value="words", defaultValue = "") String words) {

       model.addAttribute("list", shippingService.getSearch(searchType, words));

       return "shipping/list";
   }

   @GetMapping("/write")
    public  String getView() {
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

}
