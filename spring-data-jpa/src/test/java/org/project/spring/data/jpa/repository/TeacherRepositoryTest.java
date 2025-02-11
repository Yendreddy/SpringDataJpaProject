package org.project.spring.data.jpa.repository;

import org.junit.jupiter.api.Test;
import org.project.spring.data.jpa.entity.Course;
import org.project.spring.data.jpa.entity.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TeacherRepositoryTest {

    @Autowired
    private TeacherRepository teacherRepository;

    @Test
    public void saveTeacher(){
        Course courseOp = Course.builder()
                .title("Optimizing techniques")
                .credit(3)
                .build();
        Course courseDbms = Course.builder()
                .title("DBMS")
                .credit(8)
                .build();
        Teacher teacher = Teacher.builder()
                .firstName("Faria")
                .lastName("Khan")
                //.courses(List.of(courseDbms,courseOp))
                .build();
    }
}