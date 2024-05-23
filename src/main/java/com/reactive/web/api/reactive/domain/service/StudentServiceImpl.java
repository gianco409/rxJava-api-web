package com.reactive.web.api.reactive.domain.service;

import com.reactive.web.api.reactive.domain.dto.CreateResponse;
import com.reactive.web.api.reactive.domain.dto.StudentRequest;
import com.reactive.web.api.reactive.domain.dto.StudentResponse;
import com.reactive.web.api.reactive.domain.mapper.StudentMapper;
import com.reactive.web.api.reactive.infrastructure.repository.entity.Student;
import com.reactive.web.api.reactive.infrastructure.repository.sql.StudentRepository;
import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.Single;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@NoArgsConstructor
@AllArgsConstructor
@Service
public class StudentServiceImpl implements StudentService{

    private StudentRepository repository;
    private StudentMapper mapper;

    @Override
    public Single<CreateResponse> createStudent(StudentRequest request) {
        return Single.create(singleEmitter -> {
            CreateResponse response = new CreateResponse();
            Long id = Objects.requireNonNull(repository.save(mapper.modelToEntity(request)).block()).getId();
            response.setId(id);
            singleEmitter.onSuccess(response);
        });
    }

    @Override
    public Completable updateStudent(StudentRequest request) {
        return Completable.create(completableEmitter -> {
            Optional<Student> optionalStudent = repository.findById(request.getId()).blockOptional();
            if(!optionalStudent.isPresent()) {
                completableEmitter.onError(new Exception());
            } else {
                Student student = optionalStudent.get();
                student.setCode(request.getCode());
                student.setStatus(request.getStatus());
                repository.save(student);
                completableEmitter.onComplete();
            }
        });
    }

    @Override
    public Single<StudentResponse> getStudentDetail(Long id) {
        return Single.create(singleEmitter -> {
            Optional<Student> optionalStudent = repository.findById(id).blockOptional();
            if(!optionalStudent.isPresent()) {
                singleEmitter.onError(new Exception());
            } else {
                StudentResponse student = mapper.entityToModel(optionalStudent.get());
                singleEmitter.onSuccess(student);
            }
        });
    }

    @Override
    public Observable<List<StudentResponse>> getActiveStudents() {
        Observable<List<Student>> students = repository.findAllByStatus("1");

        return students.flatMapIterable(list -> list)
                .map(mapper::entityToModel)
                .toList().toObservable();
    }

    @Override
    public Completable deleteStudent(Long id) {
        return Completable.create(completableEmitter -> {
            Optional<Student> optionalStudent = repository.findById(id).blockOptional();
            if(!optionalStudent.isPresent()) {
                completableEmitter.onError(new Exception());
            } else {
                repository.delete(optionalStudent.get());
                completableEmitter.onComplete();
            }
        });
    }
}
