package com.ColetteBellard.AlienDatingSite.EntityUserProfile;

import com.ColetteBellard.AlienDatingSite.EntityHomeCard.HomeCard;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@Entity
@NoArgsConstructor
public class UserProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String headline;
    private String message;
    private String image;

    @ManyToOne
    @JoinColumn(name = "homeCardId", nullable = false)
    private HomeCard homeCard;
}