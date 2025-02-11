package org.project.spring.data.jpa.repository;

import org.junit.jupiter.api.Test;
import org.project.spring.data.jpa.entity.Guardian;
import org.project.spring.data.jpa.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
//@DataJpaTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void saveStudent(){
        Student student = Student.builder()
                .emailId("durga@gamil.com")
                .firstName("Jaya")
                .lastName("Durga")
                //.guardianName("Siva Nagi Reddy")
                //.guardianEmail("nagireddy@gmail.com")
                //.guardianMobile("8652791413")
                .build();
        studentRepository.save(student);
    }

    @Test
    public void saveStudentWithGuardianDetaild(){

        Guardian guardian = Guardian.builder()
                .email("raju@gmail.com")
                .name("Raju")
                .mobile("6788997867")
                .build();
        Student student = Student.builder()
                .emailId("yomon@gamil.com")
                .firstName("Yama")
                .lastName("Raja")
                .guardian(guardian)
                .build();
        studentRepository.save(student);
    }

    @Test
    public void printAllStudent(){
        List<Student> studentList =
                studentRepository.findAll();

        System.out.println("StudentList ="  + studentList );
    }

    @Test
    public void printStudentByFirstNameContaining(){

        List<Student> students =
                studentRepository.findByFirstNameContaining("a");
        System.out.println("students=" + students);
    }

    @Test
    public void printStudentBasedOnGuardianName(){
        List<Student> students =
                studentRepository.findByGuardianName("Raju");
        System.out.println("students=" + students);
    }

    @Test
    public void printStudentByEmailAddress(){
        Student student = studentRepository.getStudentByEmailAddress("durga@gamil.com");
        System.out.println("student=" + student);
    }

    @Test
    public void printStudentFirstNameByEmailAddress(){
        String firstName = studentRepository.getStudentFirstNameByEmailAddress("durga@gamil.com");
        System.out.println("student=" + firstName);
    }

    @Test
    public void getStudentFirstNameByEmailAddressNative(){
        Student student = studentRepository.getStudentFirstNameByEmailAddressNative("durga@gamil.com");
        System.out.println("student=" + student);
    }

    @Test
    public void getStudentFirstNameByEmailAddressNativeNamedParam(){
        Student student = studentRepository.getStudentFirstNameByEmailAddressNativeNamedParam("durga@gamil.com");
        System.out.println("student=" + student);
    }

    @Test
    public void updateStudentNameByEmailId(){
        studentRepository.updateStudentNameByEmailId(
                "Y Jaya Durga",
                "durga@gamil.com"
        );
    }
}