package com.colette.bellard.alien.dating.site.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * UserProfile is an entity class representing a user's profile in the application.
 * It is annotated with @Entity, indicating that it is a JPA entity.
 * Lombok annotations are used to automatically generate getters, setters, constructors, and other common methods.
 */
@AllArgsConstructor
@Data
@Entity
@NoArgsConstructor
public class UserProfile {
    /**
     * The unique identifier for a UserProfile. It is automatically generated.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    /**
     * The name of the user.
     */
    private String name;

    /**
     * The headline of the user's profile.
     */
    private String headline;

    /**
     * The message of the user's profile.
     */
    private String message;

    /**
     * The image of the user's profile.
     */
    private String image;

    /**
     * The HomeCard associated with the user's profile.
     * It is annotated with @ManyToOne, indicating that each UserProfile is associated with one HomeCard.
     * The @JoinColumn annotation indicates that the 'homeCardId' column is used for the foreign key.
     */
    @ManyToOne
    @JoinColumn(name = "homeCardId", nullable = false)
    private HomeCard homeCard;
}