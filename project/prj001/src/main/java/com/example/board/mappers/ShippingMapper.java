package com.example.board.mappers;

import com.example.board.dto.ShippingDto;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface ShippingMapper {

    @Insert("INSERT INTO shipping VALUES(NULL, #{domestic}, #{name}, #{comNum}, #{faxNum}, " +
            "#{address1}, #{address2}, #{city}, #{country}, #{postcode}, #{email}, now(), " +
            "#{orgName}, #{savedFileName}, #{savedFilePathName}, #{savedFileSize}, #{folderName}, #{ext})")
    void setWrite(ShippingDto shippingDto);

    @Select("SELECT * FROM ${searchQuery} shipping ORDER BY id DESC")
    List<ShippingDto> getList(Map<String, Object> map);

    @Select("SELECT * FROM shipping WHERE id = #{id}")
    ShippingDto getView(int id);

}
