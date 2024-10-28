package com.app.model;

import lombok.Data;
import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.Instant;
import java.util.List;

@Entity
@Data
public class TrainingCenter {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)//default generation strategy that lets the JPA provider decide the generation method based on the underlying database.
    private Long id;

    @NotBlank(message = "Center name is required")
    @Size(max = 40, message = "Center name must be less than 40 characters")
    private String centerName;

    @NotBlank(message = "Center code is required")
    @Pattern(regexp = "^[a-zA-Z0-9]{12}$", message = "Center code must be exactly 12 alphanumeric characters")
    private String centerCode;

    @Embedded
    private Address address;

    @PositiveOrZero(message = "Student capacity must be a positive number")
    private Integer studentCapacity;

    @ElementCollection(fetch = FetchType.LAZY)//making it lazy loaded for better performance
    private List<String> coursesOffered;

    private Long createdOn;

    @Email(message = "Invalid email address")
    private String contactEmail;

    @NotBlank(message = "Contact phone is required")
    @Pattern(regexp = "^[0-9]{10}$", message = "Phone number must be exactly 10 digits")
    private String contactPhone;
}



