package com.traini8.org.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "training_center_contact")
public class ContactInfo {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "training_center_id", nullable = false, unique = true)
    private TrainingCenter trainingCenter;

    @Column(name = "contact_email", length = 255)
    @Email(message = "Invalid email format")
    private String contactEmail;

    @Column(name = "contact_phone", nullable = false, length = 10)
    @Pattern(regexp = "^[0-9]{10}$", message = "Phone number must be exactly 10 digits")
    private String contactPhone;
}
