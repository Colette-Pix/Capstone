package com.colette.bellard.alien.dating.site.models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * AlienEntity is an entity class representing a user's profile in the application.
 * It is annotated with @Entity, indicating that it is a JPA entity.
 * Lombok annotations are used to automatically generate getters, setters, constructors, and other common methods.
 */
@AllArgsConstructor
@Data
@Entity
@NoArgsConstructor
public class Alien {
    /**
     * The unique identifier. It is automatically generated.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    /**
     * The name of the alien.
     */
    @Column(name = "name")
    private String name;

    @OneToOne
    @JoinColumn(name = "Home Card", nullable = false)
    private HomeCard homeCard;
}