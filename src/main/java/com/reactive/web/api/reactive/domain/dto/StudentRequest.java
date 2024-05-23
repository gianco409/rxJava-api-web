package com.reactive.web.api.reactive.domain.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class StudentRequest implements Serializable {
    private Long id;
    private String firstName;
    private String lastName;
    private String fullName;
    private String code;
    private String status;
    private Date createdAt;
    private Date updatedAt;
}
