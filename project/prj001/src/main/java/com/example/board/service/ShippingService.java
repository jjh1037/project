package com.example.board.service;

import com.example.board.dto.ShippingDto;
import com.example.board.mappers.ShippingMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ShippingService {

    @Autowired
    ShippingMapper shippingMapper;

    public List<ShippingDto> getSearch(String searchType, String words) {
        Map<String, Object> map = new HashMap<>();

        String searchQuery= "";
        if(searchType.equals("name")) {
            searchQuery = "WHERE " + searchType + " LIKE '%"+words+"%'";
        }else if(searchType.equals("id")) {
            searchQuery = "WHERE " + searchType + " = '" + words + "'";
        }else {
            searchQuery = "";
        }

        map.put("searchQuery", searchQuery);

        return shippingMapper.getList(map);
    }

    public void setDelete(int id) {
        if(id > 0) {
            ShippingDto shippingDto = shippingMapper.getView(id);
            shippingMapper.setDelete(id);

            String removeFile = shippingDto.getSavedFilePathName();
            if(removeFile != null) {
                File f = new File(removeFile);
                if(f.exists()) {
                    f.delete();
                }
            }
        }
    }

}
