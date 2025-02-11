package org.project.spring.data.jpa.repository;

import org.junit.jupiter.api.Test;
import org.project.spring.data.jpa.entity.Course;
import org.project.spring.data.jpa.entity.CourseMaterial;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseMaterialRepositoryTest {

    @Autowired
    private CourseMaterialRepository repository;

    @Test
    public void saveCourseMaterial(){
        Course course = Course.builder()
                .title("Computer networks")
                .credit(7)
                .build();

        CourseMaterial courseMaterial =
                CourseMaterial.builder()
                        .url("www.googler.com")
                        .course(course)
                        .build();
        repository.save(courseMaterial);
    }

    @Test
    public void printAllCourseMaterials(){
        List<CourseMaterial> courseMaterials =
                repository.findAll();
        System.out.println("courseMaterials =" + courseMaterials);
    }

}