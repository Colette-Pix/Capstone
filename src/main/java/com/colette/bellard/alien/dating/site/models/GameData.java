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
public class GameData {
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

    private int highScore;

    @ManyToOne
    @JoinColumn(name = "gameDataId", nullable = false)
    private HomeCard homeCard;
}