package com.reactive.web.api.reactive.infrastructure.repository.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.Date;

@Data
public class Student {
    @Id
    private Long id;
    private String firstName;
    private String lastName;
    private String fullName;
    private String code;
    private String status;
    private Date createdAt;
    private Date updatedAt;
}
