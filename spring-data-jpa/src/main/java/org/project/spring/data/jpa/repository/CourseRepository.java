package org.project.spring.data.jpa.repository;

import org.project.spring.data.jpa.entity.Course;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CourseRepository extends JpaRepository<Course, UUID> {
//    @Query("SELECT c FROM Course c JOIN FETCH c.students ORDER BY c.title")
    Page<Course> findByTitleContaining(
            String title,
            Pageable pageable
    );
}
