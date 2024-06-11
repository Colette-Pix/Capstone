package com.colette.bellard.alien.dating.site.entity.user.profile;

import com.colette.bellard.alien.dating.site.entity.home.card.HomeCard;
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