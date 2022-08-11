package com.soydomain.stava.wingapp.Model;

import java.util.List;

public class ResponseModel {
    //Response Code
    private int code;
    private String message;
    //Array Data
    private List<ProductModel> data;
    //Product Data
    private String product_code;
    private String product_name;
    private int price;
    private String currency;
    private int discount;
    private String dimension;
    private String unit;
    //Transaction Data
    private String doc_code;
    private String doc_num;
    private String user;
    private int total;
    private String date;
    //Trans Detail Data
    private int quantity;
    private int subtotal;

    //Response Data
    public int getCode() {
        return code;
    }
    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }

    //Array Response Data
    public List<ProductModel> getData() {
        return data;
    }
    public void setData(List<ProductModel> data) {
        this.data = data;
    }

    //Database Data
    public String getProduct_code() {
        return product_code;
    }
    public void setProduct_code(String product_code) {
        this.product_code = product_code;
    }

    public String getProduct_name() {
        return product_name;
    }
    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }

    public String getCurrency() {
        return currency;
    }
    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public int getDiscount() {
        return discount;
    }
    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public String getDimension() {
        return dimension;
    }
    public void setDimension(String dimension) {
        this.dimension = dimension;
    }

    public String getUnit() {
        return unit;
    }
    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getDoc_code() {
        return doc_code;
    }
    public void setDoc_code(String doc_code) {
        this.doc_code = doc_code;
    }

    public String getDoc_num() {
        return doc_num;
    }
    public void setDoc_num(String doc_num) {
        this.doc_num = doc_num;
    }

    public String getUser() {
        return user;
    }
    public void setUser(String user) {
        this.user = user;
    }

    public int getTotal() {
        return total;
    }
    public void setTotal(int total) {
        this.total = total;
    }

    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }

    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getSubtotal() {
        return subtotal;
    }
    public void setSubtotal(int subtotal) {
        this.subtotal = subtotal;
    }
}
