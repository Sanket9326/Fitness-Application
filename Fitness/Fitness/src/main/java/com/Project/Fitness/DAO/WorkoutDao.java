package com.Project.Fitness.DAO;

import com.Project.Fitness.Model.WorkoutEntry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WorkoutDao extends JpaRepository<WorkoutEntry, Integer> {
    @Query(value = "SELECT * FROM workout_entry WHERE username = :username AND date <= :end AND date >= :start",nativeQuery = true)
    List<WorkoutEntry> getDetailsByUsername(@Param("username") String username,@Param("start") String start,@Param("end") String end);
}
