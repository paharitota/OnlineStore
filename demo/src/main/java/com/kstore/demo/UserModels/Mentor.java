package com.kstore.demo.UserModels;

import jakarta.persistence.Entity;
import lombok.Data;

@Entity(name = "MENTOR_TABLE")
@Data
public class Mentor extends User{

    private double mentorRating;
    
}
