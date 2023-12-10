package com.example.adminPage.dto;

public class ShippingDto {
    private int id;
    private boolean domestic;
    private String name;
    private String comNum;
    private String faxNum;
    private String address1;
    private String address2;
    private String city;
    private String country;
    private String postcode;
    private String email;
    private String regdate;
    private String orgName ;
    private String savedFileName ;
    private String savedFilePathName ;
    private Long savedFileSize ;
    private String folderName;
    private String ext ;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isDomestic() {
        return domestic;
    }

    public void setDomestic(boolean domestic) {
        this.domestic = domestic;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getComNum() {
        return comNum;
    }

    public void setComNum(String comNum) {
        this.comNum = comNum;
    }

    public String getFaxNum() {
        return faxNum;
    }

    public void setFaxNum(String faxNum) {
        this.faxNum = faxNum;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRegdate() {
        return regdate;
    }

    public void setRegdate(String regdate) {
        this.regdate = regdate;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getSavedFileName() {
        return savedFileName;
    }

    public void setSavedFileName(String savedFileName) {
        this.savedFileName = savedFileName;
    }

    public String getSavedFilePathName() {
        return savedFilePathName;
    }

    public void setSavedFilePathName(String savedFilePathName) {
        this.savedFilePathName = savedFilePathName;
    }

    public Long getSavedFileSize() {
        return savedFileSize;
    }

    public void setSavedFileSize(Long savedFileSize) {
        this.savedFileSize = savedFileSize;
    }

    public String getFolderName() {
        return folderName;
    }

    public void setFolderName(String folderName) {
        this.folderName = folderName;
    }

    public String getExt() {
        return ext;
    }

    public void setExt(String ext) {
        this.ext = ext;
    }

    @Override
    public String toString() {
        return "ShippingDto{" +
                "id=" + id +
                ", domestic=" + domestic +
                ", name='" + name + '\'' +
                ", comNum='" + comNum + '\'' +
                ", faxNum='" + faxNum + '\'' +
                ", address1='" + address1 + '\'' +
                ", address2='" + address2 + '\'' +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", postcode='" + postcode + '\'' +
                ", email='" + email + '\'' +
                ", regdate='" + regdate + '\'' +
                ", orgName='" + orgName + '\'' +
                ", savedFileName='" + savedFileName + '\'' +
                ", savedFilePathName='" + savedFilePathName + '\'' +
                ", savedFileSize=" + savedFileSize +
                ", folderName='" + folderName + '\'' +
                ", ext='" + ext + '\'' +
                '}';
    }
}
