package com.kstore.demo.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Data;

;


@Data
@Entity

public class Products extends BaseModel {

private String title;
private double price;
private String Description;
private String image;

@ManyToOne
private Category category;

}
