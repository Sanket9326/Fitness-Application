package com.Project.Fitness.DAO;

import com.Project.Fitness.Model.MotivationalQuotes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface QuoteDao extends JpaRepository<MotivationalQuotes,Integer> {
    @Query(value = "SELECT quote FROM motivational_quotes WHERE day_of_week = :day ",nativeQuery = true)
    String getQuote(@Param("day") String day);
}
