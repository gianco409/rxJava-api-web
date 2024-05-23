package com.reactive.web.api.reactive.application.rest;

import com.reactive.web.api.reactive.domain.dto.StudentResponse;
import com.reactive.web.api.reactive.domain.service.StudentService;
import io.reactivex.Single;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/api/student")
public class StudentController {
    private final StudentService service;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Single<ResponseEntity<StudentResponse>> createStudent() {
        return null;
    }

    @PutMapping(value = "/{id}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Single<ResponseEntity<StudentResponse>> udpateStudent() {
        return null;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public Single<ResponseEntity<List<StudentResponse>>> getStudents() {
        return null;
    }

    @GetMapping(value = "/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Single<ResponseEntity<StudentResponse>> getStudent() {
        return null;
    }

    @DeleteMapping(value = "/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Single<ResponseEntity<StudentResponse>> deleteStudent() {
        return null;
    }
}
