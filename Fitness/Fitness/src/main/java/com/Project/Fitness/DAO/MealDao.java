package com.Project.Fitness.DAO;

import com.Project.Fitness.Model.Meal;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MealDao extends JpaRepository<Meal, Integer> {

    @Query(value = "SELECT * FROM Meal WHERE username = :username",nativeQuery = true)
    List<Meal> getDetails(@Param("username") String username);

    @Modifying
    @Transactional
    @Query(value = "Delete from Meal where username = :username and meal_type = :mealType and time = :time",nativeQuery = true)
    void deleteThisRecord(@Param("username") String username,@Param("mealType") String mealType,@Param("time") String time);
}
