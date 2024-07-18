package com.Project.Fitness.DAO;

import com.Project.Fitness.Model.Goal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GoalDao extends JpaRepository<Goal, Integer> {
}
