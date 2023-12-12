package com.example.adminPage.mappers;

import com.example.adminPage.dto.RequestDto;
import com.example.adminPage.dto.ShippingDto;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

@Mapper
public interface UserShippingMapper {
    @Select("SELECT * FROM shipping ${searchQuery} ORDER BY id DESC LIMIT #{startNum}, #{offset}")
    List<ShippingDto> getList(Map<String, Object> map);

    @Select("SELECT * FROM shipping WHERE id = #{id}")
    ShippingDto getView(int id);

    @Select("SELECT COUNT(*) FROM shipping ${searchQuery}")
    int getListCount(Map<String, Object> map);

    @Select("SELECT COUNT(*) FROM shipping")
    int totalCount();

    @Insert("INSERT INTO request VALUES(NULL, #{requestName}, #{requestNum}, #{requestEmail}, #{requestExportCountry}, #{requestExportCity}, #{requestExportDate}, #{requestImportCountry}, #{requestImportCity}, #{requestImportDate}, #{requestProduct}, #{requestContent}, #{id})")
    void setRequest(RequestDto requestDto);
}
