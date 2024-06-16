package com.kstore.demo.UserModels;

import jakarta.persistence.Entity;
import lombok.Data;

@Entity(name = "TA_TABLE")
@Data


public class TA extends User{

    private int noOfSession;
    private double rating;
 }
