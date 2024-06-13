package com.colette.bellard.alien.dating.site.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * HomeCard is an entity class representing an alien profile in the application.
 * It is annotated with @Entity, indicating that it is a JPA entity.
 * Lombok annotations are used to automatically generate getters, setters, constructors, and other common methods.
 */
@AllArgsConstructor
@Data
@Entity
@NoArgsConstructor
public class HomeCard {
    /**
     * The unique identifier for a HomeCard. It is automatically generated.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    /**
     * The name of the alien.
     */
    private String name;

    /**
     * The job of the alien.
     */
    private String job;

    /**
     * The status of the alien.
     */
    private String status;

    /**
     * The resonance of the alien.
     */
    private String resonance;

    /**
     * The image of the alien.
     */
    private String image;
}