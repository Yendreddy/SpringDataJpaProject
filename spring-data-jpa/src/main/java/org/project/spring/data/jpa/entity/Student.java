package org.project.spring.data.jpa.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(
        name = "tbl_student",
        uniqueConstraints = @UniqueConstraint(
                name = "emailId_unique",
        columnNames = "email_address"
        )
)
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "student_identification_number")
    private UUID studentIdentificationNumber;
    @Column(name = "student_name")
    private String firstName;
    @Column(name = "student_surname")
    private String lastName;
    @Column(name = "email_address",
            nullable = false
    )
    private String emailId;

    @Embedded
    private Guardian guardian;

}
