package com.ColetteBellard.AlienDatingSite.EntityHomeCard;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//used for alien profiles
@AllArgsConstructor
@Data
@Entity
@NoArgsConstructor
public class HomeCard {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String job;
    private String status;
    private String resonance;
    private String image;



}