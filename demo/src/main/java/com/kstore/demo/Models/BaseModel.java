package com.kstore.demo.Models;

import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;

import java.util.Date;

@Data
@MappedSuperclass
public class BaseModel {
   @Id

    private long id;
    private Date createdAt;
    private Date updatedAt;
}
