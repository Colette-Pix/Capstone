package com.colette.bellard.alien.dating.site.entity.user.profile;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * UserProfileRepository is a Spring Data JPA repository for the UserProfile entity.
 * It extends JpaRepository, which provides methods for CRUD operations.
 */
public interface UserProfileRepository extends JpaRepository<UserProfile, Integer> {

    /**
     * This method is used to find UserProfiles by their name.
     * It uses a custom query to select UserProfiles from the database where the name matches the provided parameter.
     *
     * @param name the name of the UserProfile to find
     * @return a list of UserProfiles with the provided name
     */
    @Query("SELECT u FROM UserProfile u WHERE u.name = :name")
    List<UserProfile>  findByName(@Param("name") String name);
}