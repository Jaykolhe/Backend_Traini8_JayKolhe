package com.traini8.org.model;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;
import java.util.Set;

@Getter
@Setter
public class TrainingCenterRequestDto {


    @NotBlank(message = "Center name is required")
    @Size(max = 39, message = "Center name must be less than 40 characters")
    private String centerName;

    @NotBlank(message = "Center code is required")
    @Pattern(regexp = "^[A-Za-z0-9]{12}$", message = "Center code must be 12 alphanumeric characters")
    private String centerCode;

    private Integer studentCapacity;

    // Address entity data
    @NotBlank(message = "Detailed address is required")
    private String detailedAddress;

    @NotBlank(message = "City is required")
    private String city;

    @NotBlank(message = "State is required")
    private String state;

    @Pattern(regexp = "^[0-9]{6}$", message = "Pincode must be exactly 6 digits")
    private String pincode;

    // Contact Info Entity data
    @Email(message = "Invalid email format")
    private String contactEmail;

    @Pattern(regexp = "^[0-9]{10}$", message = "Phone number must be exactly 10 digits")
    private String contactPhone;

    // Courses entity data
    private Set<String> courses; // List of course names
}
