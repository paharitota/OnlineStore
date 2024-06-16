package com.kstore.demo.dto;


import jdk.jfr.Category;
import lombok.Data;

@Data
public class FakeStoreResponseDto {

    private  long id;
    private String title;
    private double price;
    private String Description;
    private String image;
    private String category;
}
