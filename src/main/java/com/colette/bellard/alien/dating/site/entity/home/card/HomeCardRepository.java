package com.colette.bellard.alien.dating.site.entity.home.card;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface HomeCardRepository extends JpaRepository<HomeCard, Integer> {
    @Query("SELECT u FROM UserProfile u WHERE u.name = :name")
    List<HomeCard>  findByName(@Param("name") String name);
}