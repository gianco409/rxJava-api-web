package com.reactive.web.api.reactive.domain.service;

import com.reactive.web.api.reactive.domain.dto.CreateResponse;
import com.reactive.web.api.reactive.domain.dto.StudentRequest;
import com.reactive.web.api.reactive.domain.dto.StudentResponse;
import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.Single;

import java.util.List;

public interface StudentService {
    Single<CreateResponse> createStudent(StudentRequest request);
    Completable updateStudent(StudentRequest request);
    Single<StudentResponse> getStudentDetail(Long id);
    Observable<List<StudentResponse>> getActiveStudents();
    Completable deleteStudent(Long id);
}
