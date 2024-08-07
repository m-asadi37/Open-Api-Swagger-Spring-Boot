package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Table(name = "user_demo")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String family;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date birth;

    public Long getId() {
        return id;
    }

    public User setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public User setName(String name) {
        this.name = name;
        return this;
    }

    public String getFamily() {
        return family;
    }

    public User setFamily(String family) {
        this.family = family;
        return this;
    }

    public Date getBirth() {
        return birth;
    }

    public User setBirth(Date birth) {
        this.birth = birth;
        return this;
    }
}
