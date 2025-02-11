package org.project.spring.data.jpa.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID courseId;
    private String title;
    private Integer credit;

    @OneToOne(
            mappedBy = "course"
    )
    private CourseMaterial courseMaterial;

    @ManyToOne(
        cascade = CascadeType.ALL
    )
    @JoinColumn(
            name = "teacher_id",
            referencedColumnName = "teacherId"
    )
    private Teacher teacher;

    @ManyToMany(
            cascade = CascadeType.ALL
    )
    @JoinTable(name = "student_course_map",
    joinColumns = @JoinColumn(
            name = "course_id",
            referencedColumnName = "courseId"
    ),
    inverseJoinColumns = @JoinColumn(
            name = "student_identification_number",
            referencedColumnName = "student_identification_number"))

    private List<Student> students;

    public void addStudents(Student student){
        if(students == null) students = new ArrayList<>();
        students.add(student);

    }
}
