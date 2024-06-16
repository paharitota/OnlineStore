package com.kstore.demo.UserModels;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import lombok.Data;
import org.springframework.boot.autoconfigure.web.WebProperties;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Data

public class User {
    @Id
    private long id;
    private  String name;
    private String email;

    private String password;
}
