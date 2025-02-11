package org.project.spring.data.jpa.repository;

import jakarta.transaction.Transactional;
import org.project.spring.data.jpa.entity.Course;
import org.project.spring.data.jpa.entity.Student;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface StudentRepository extends JpaRepository<Student, UUID> {

    public List<Student> findByFirstName(String firstName);

    public List<Student> findByFirstNameContaining(String name);

    public List<Student> findByLastNameNotNull();

    public List<Student> findByGuardianName(String name);

    Student findByFirstNameAndLastName(String firstName, String lastName);

    //JPQL
    @Query("select s from Student s where s.emailId = ?1")
    Student getStudentByEmailAddress(String emailId);

    @Query("select s.firstName from Student s where s.emailId = ?1")
    String getStudentFirstNameByEmailAddress(String emailId);

    //Native Queries
    @Query(
            value = "select * from tbl_student s where s.email_address = ?1",
            nativeQuery = true
    )
    Student getStudentFirstNameByEmailAddressNative(String emailId);

    //Native Queries
    @Query(
            value = "select * from tbl_student s where s.email_address = :emailId",
            nativeQuery = true
    )
    Student getStudentFirstNameByEmailAddressNativeNamedParam(
            @Param("emailId") String emailId
    );

    @Modifying
    @Transactional
    @Query(
            value = "update tbl_student set student_name = ?1 where email_address = ?2",
            nativeQuery = true
    )
    int updateStudentNameByEmailId(String firstName, String emailId);


}
