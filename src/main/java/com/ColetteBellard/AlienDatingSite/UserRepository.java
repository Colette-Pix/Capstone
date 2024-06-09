package com.ColetteBellard.AlienDatingSite;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<UserProfile, Integer> {
    @Query("SELECT u FROM UserProfile u WHERE u.name = :name")
    List<UserProfile>  findByName(@Param("name") String name);

}