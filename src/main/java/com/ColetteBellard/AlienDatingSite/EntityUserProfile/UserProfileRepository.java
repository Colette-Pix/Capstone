package com.ColetteBellard.AlienDatingSite.EntityUserProfile;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserProfileRepository extends JpaRepository<UserProfile, Integer> {
    @Query("SELECT u FROM UserProfile u WHERE u.name = :name")
    List<UserProfile>  findByName(@Param("name") String name);

}