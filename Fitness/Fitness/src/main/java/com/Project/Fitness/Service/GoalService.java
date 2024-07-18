package com.Project.Fitness.Service;

import com.Project.Fitness.DAO.GoalDao;
import com.Project.Fitness.Model.Goal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class GoalService {

    @Autowired
    GoalDao goalDao;

    public ResponseEntity<String> setGoal(String username, String goalType, String description, String startDate, String endDate, String target) {
        try{

            Goal goal = new Goal();
            goal.setUsername(username);
            goal.setGoalType(goalType);
            goal.setDescription(description);
            goal.setStartDate(startDate);
            goal.setEndDate(endDate);
            goal.setTarget(target);
            goalDao.save(goal);
            return new ResponseEntity<>("Goal saved successfully", HttpStatus.OK);

        }catch (Exception e){

            return new ResponseEntity<>("Error", HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }
    public ResponseEntity<String> updateGoal(String username, String goalType, String target, String description, String startDate, String endDate) {
        try{

            Goal goal = new Goal();
            goal.setUsername(username);
            goal.setGoalType(goalType);
            goal.setTarget(target);
            goal.setDescription(description);
            goal.setStartDate(startDate);
            goal.setEndDate(endDate);
            goalDao.delete(goal);
            goalDao.save(goal);
            return new ResponseEntity<>("Goal updated successfully", HttpStatus.OK);

        }catch (Exception e){

            return new ResponseEntity<>("Error", HttpStatus.INTERNAL_SERVER_ERROR);

        }

    }
}
