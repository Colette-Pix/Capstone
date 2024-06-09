package com.ColetteBellard.AlienDatingSite;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
//used for alien profiles
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
    //we would also add a foreign key for alien cards


}