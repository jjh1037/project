package com.example.adminPage.dto;

public class RequestDto {
    private int requestId;
    private String requestName;
    private String requestNum;
    private String requestEmail;
    private String requestExportCountry;
    private String requestExportCity;
    private String requestExportDate;
    private String requestImportCountry;
    private String requestImportCity;
    private String requestImportDate;
    private int requestProduct;
    private String requestContent;
    private int id;

    public int getRequestId() {
        return requestId;
    }

    public void setRequestId(int requestId) {
        this.requestId = requestId;
    }

    public String getRequestName() {
        return requestName;
    }

    public void setRequestName(String requestName) {
        this.requestName = requestName;
    }

    public String getRequestNum() {
        return requestNum;
    }

    public void setRequestNum(String requestNum) {
        this.requestNum = requestNum;
    }

    public String getRequestEmail() {
        return requestEmail;
    }

    public void setRequestEmail(String requestEmail) {
        this.requestEmail = requestEmail;
    }

    public String getRequestExportCountry() {
        return requestExportCountry;
    }

    public void setRequestExportCountry(String requestExportCountry) {
        this.requestExportCountry = requestExportCountry;
    }

    public String getRequestExportCity() {
        return requestExportCity;
    }

    public void setRequestExportCity(String requestExportCity) {
        this.requestExportCity = requestExportCity;
    }

    public String getRequestExportDate() {
        return requestExportDate;
    }

    public void setRequestExportDate(String requestExportDate) {
        this.requestExportDate = requestExportDate;
    }

    public String getRequestImportCountry() {
        return requestImportCountry;
    }

    public void setRequestImportCountry(String requestImportCountry) {
        this.requestImportCountry = requestImportCountry;
    }

    public String getRequestImportCity() {
        return requestImportCity;
    }

    public void setRequestImportCity(String requestImportCity) {
        this.requestImportCity = requestImportCity;
    }

    public String getRequestImportDate() {
        return requestImportDate;
    }

    public void setRequestImportDate(String requestImportDate) {
        this.requestImportDate = requestImportDate;
    }

    public int getRequestProduct() {
        return requestProduct;
    }

    public void setRequestProduct(int requestProduct) {
        this.requestProduct = requestProduct;
    }

    public String getRequestContent() {
        return requestContent;
    }

    public void setRequestContent(String requestContent) {
        this.requestContent = requestContent;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "RequestDto{" +
                "requestId=" + requestId +
                ", requestName='" + requestName + '\'' +
                ", requestNum='" + requestNum + '\'' +
                ", requestEmail='" + requestEmail + '\'' +
                ", requestExportCountry='" + requestExportCountry + '\'' +
                ", requestExportCity='" + requestExportCity + '\'' +
                ", requestExportDate='" + requestExportDate + '\'' +
                ", requestImportCountry='" + requestImportCountry + '\'' +
                ", requestImportCity='" + requestImportCity + '\'' +
                ", requestImportDate='" + requestImportDate + '\'' +
                ", requestProduct=" + requestProduct +
                ", requestContent='" + requestContent + '\'' +
                ", id=" + id +
                '}';
    }
}
