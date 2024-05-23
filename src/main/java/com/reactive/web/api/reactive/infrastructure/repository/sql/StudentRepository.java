package com.reactive.web.api.reactive.infrastructure.repository.sql;

import com.reactive.web.api.reactive.infrastructure.repository.entity.Student;
import io.reactivex.Observable;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends ReactiveCrudRepository<Student, Long> {
    Observable<List<Student>> findAllByStatus(String status);
}
