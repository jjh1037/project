package com.example.adminPage.mappers;

import com.example.adminPage.dto.ShippingDto;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

@Mapper
public interface ShippingMapper {

    @Insert("INSERT INTO shipping VALUES(NULL, #{domestic}, #{name}, #{comNum}, #{faxNum}, " +
            "#{address1}, #{address2}, #{city}, #{country}, #{postcode}, #{email}, now(), " +
            "#{orgName}, #{savedFileName}, #{savedFilePathName}, #{savedFileSize}, #{folderName}, #{ext})")
    void setWrite(ShippingDto shippingDto);

    @Select("SELECT * FROM shipping ${searchQuery} ORDER BY id DESC LIMIT #{startNum}, #{offset}")
    List<ShippingDto> getList(Map<String, Object> map);

    @Select("SELECT * FROM shipping WHERE id = #{id}")
    ShippingDto getView(int id);

    @Select("SELECT COUNT(*) FROM shipping ${searchQuery}")
    int getListCount(Map<String, Object> map);

    @Select("SELECT COUNT(*) FROM shipping")
    int totalCount();

    @Delete("DELETE FROM shipping WHERE id = #{id}")
    void setDelete(int id);

    @Update("UPDATE shipping SET domestic=#{domestic}, name=#{name}, com_num=#{comNum}, fax_num=#{faxNum}, " +
            "address1=#{address1}, address2=#{address2}, city=#{city}, country=#{country}, postcode=#{postcode}, email=#{email}, " +
            "orgName=#{orgName}, savedFileName=#{savedFileName}, savedFilePathName=#{savedFilePathName}, savedFileSize=#{savedFileSize}, folderName=#{folderName}, ext=#{ext}" +
            "WHERE id=#{id}")
    void setUpdate(ShippingDto shippingDto);

}
