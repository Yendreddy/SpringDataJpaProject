package org.project.spring.data.jpa.entity;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@AttributeOverrides({
        @AttributeOverride(
                name = "name",
                column = @Column(name = "name_of_guardian")
        ),
        @AttributeOverride(
                name = "email",
                column = @Column(name = "guardian_email_address")
        ),
        @AttributeOverride(
                name = "mobile",
                column = @Column(name = "guardian_phone_number")
        )
})
public class Guardian {

    @Column(name = "name_of_guardian")
    private String name;
    @Column(name  = "guardian_email_address")
    private String email;
    @Column(name = "guardian_phone_number")
    private String mobile;
}
