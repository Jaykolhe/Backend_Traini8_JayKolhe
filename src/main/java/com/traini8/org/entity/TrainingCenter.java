package com.traini8.org.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;
import java.time.Instant;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "training_centers")
public class TrainingCenter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "center_name", nullable = false, length = 39)
    @Size(max = 39, message = "Center name must be less than 40 characters")
    @NotBlank(message = "Center name is required")
    private String centerName;

    @Column(name = "center_code", unique = true, nullable = false, length = 12)
    @Pattern(regexp = "^[A-Za-z0-9]{12}$", message = "Center code must be 12 alphanumeric characters")
    private String centerCode;

    @Column(name = "student_capacity")
    private Integer studentCapacity;

    @Column(name = "created_on", updatable = false, nullable = false)
    private Long createdOn;

    @OneToOne(mappedBy = "trainingCenter", cascade = CascadeType.ALL, orphanRemoval = true)
    private Address address;

    @OneToOne(mappedBy = "trainingCenter", cascade = CascadeType.ALL, orphanRemoval = true)
    private ContactInfo contactInfo;

    @ManyToMany
    @JoinTable(
            name = "training_center_courses",
            joinColumns = @JoinColumn(name = "training_center_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id")
    )
    private Set<Course> courses;

    @PrePersist
    protected void onCreate() {
        this.createdOn = Instant.now().toEpochMilli();
    }
}
