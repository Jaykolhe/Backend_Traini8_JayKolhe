package com.traini8.org.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
@Table(name = "training_centere_addresses")
public class Address {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "training_center_id", nullable = false, unique = true)
    private TrainingCenter trainingCenter;

    @Column(name = "detailed_address", nullable = false, columnDefinition = "TEXT")
    @NotBlank(message = "Detailed address is required")
    private String detailedAddress;

    @Column(name = "city", nullable = false, length = 100)
    @NotBlank(message = "City is required")
    private String city;

    @Column(name = "state", nullable = false, length = 100)
    @NotBlank(message = "State is required")
    private String state;

    @Column(name = "pincode", nullable = false, length = 6)
    @Pattern(regexp = "^[0-9]{6}$", message = "Pincode must be exactly 6 digits")
    private String pincode;
}
