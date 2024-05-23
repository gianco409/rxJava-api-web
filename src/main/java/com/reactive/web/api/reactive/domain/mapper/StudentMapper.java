package com.reactive.web.api.reactive.domain.mapper;

import com.reactive.web.api.reactive.domain.dto.StudentRequest;
import com.reactive.web.api.reactive.domain.dto.StudentResponse;
import com.reactive.web.api.reactive.infrastructure.repository.entity.Student;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.springframework.stereotype.Component;


@Component
@Mapper(componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
    nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface StudentMapper {
    Student modelToEntity(StudentRequest request);
    StudentResponse entityToModel(Student entity);
}
