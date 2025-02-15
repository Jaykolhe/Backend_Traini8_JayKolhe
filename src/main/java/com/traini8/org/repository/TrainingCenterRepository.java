package com.traini8.org.repository;

import com.traini8.org.entity.TrainingCenter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TrainingCenterRepository extends JpaRepository<TrainingCenter, Long> {

    @Query("SELECT tc FROM TrainingCenter tc LEFT JOIN FETCH tc.address LEFT JOIN FETCH tc.contactInfo LEFT JOIN FETCH tc.courses WHERE tc.id = :id")
    Optional<TrainingCenter> findByIdWithDetails(@Param("id") Long id);
}
