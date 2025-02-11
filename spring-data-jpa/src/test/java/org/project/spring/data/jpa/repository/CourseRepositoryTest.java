package org.project.spring.data.jpa.repository;

import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.project.spring.data.jpa.entity.Course;
import org.project.spring.data.jpa.entity.Student;
import org.project.spring.data.jpa.entity.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

@SpringBootTest
@Transactional
class CourseRepositoryTest {

    @Autowired
    private CourseRepository courseRepository;

    @Test
    public void printCourses(){
        List<Course> courses = courseRepository.findAll();
        System.out.println("courses = " + courses );
    }

    @Test
    public void saveCourseWithTeacher(){
        Teacher teacher = Teacher.builder()
                .firstName("ria")
                .lastName("sharma")
                .build();

        Course course = Course.builder()
                .title("python")
                .credit(5)
                .teacher(teacher)
                .build();

        courseRepository.save(course);
    }

    @Test
    public void findAllPagination() {
        Pageable firstPageWithThreeRecords = (Pageable) PageRequest.of(0, 3, Sort.by("courseId").ascending());
        Pageable secondPageWithTwoRecords = (Pageable) PageRequest.of(1, 2, Sort.by("courseId").ascending());

        Page<Course> firstPage = courseRepository.findAll((org.springframework.data.domain.Pageable) firstPageWithThreeRecords);
        Page<Course> secondPage = courseRepository.findAll((org.springframework.data.domain.Pageable) secondPageWithTwoRecords);

        List<Course> courses = firstPage.getContent();
        long totalElements = firstPage.getTotalElements();
        int totalPages = firstPage.getTotalPages();

        System.out.println("totalPages=" + totalPages);
        System.out.println("totalElements=" + totalElements);
        System.out.println("courses=" + courses);
    }
    @Test
    public void findAllSorting(){
        Pageable sortByTitle =
                PageRequest.of(0,2,Sort.by("title"));
        Pageable sortByCreditDesc =
                PageRequest.of(0,2,Sort.by("credit").descending());

        List<Course> courses =
                courseRepository.findAll(sortByTitle).getContent();
        System.out.println("courses =" +courses);

    }
    @Test
    public void printFindByTitleContaining(){
        Pageable firstPageTenRecords =
                PageRequest.of(0,10);
        List<Course> courses =
                courseRepository.findByTitleContaining("n", firstPageTenRecords).getContent();
        System.out.println("courses =" +courses);
    }

    @Test
    public void saveCourseWithStudentAndTeacher(){
        Teacher teacher = Teacher.builder()
                .firstName("yam")
                .lastName("rat")
                .build();
        Student student = Student.builder()
                .firstName("rea")
                .lastName("tom")
                .emailId("yudw@gmail.com")
                .build();
        Course course = Course.builder()
                .title("AI")
                .credit(5)
                .teacher(teacher)
                .build();
        course.addStudents(student);

        courseRepository.save(course);
    }
}