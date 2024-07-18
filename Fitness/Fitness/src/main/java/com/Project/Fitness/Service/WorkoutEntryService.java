package com.Project.Fitness.Service;

import com.Project.Fitness.DAO.WorkoutDao;
import com.Project.Fitness.Model.WorkoutEntry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class WorkoutEntryService {
    @Autowired
    WorkoutDao workoutDao;

    public ResponseEntity<String> dailyWorkout(String username, String date, String workoutType, int duration, float calories) {
        try{
            WorkoutEntry workoutEntry = new WorkoutEntry();
            workoutEntry.setUsername(username);
            workoutEntry.setDate(date);
            workoutEntry.setWorkoutType(workoutType);
            workoutEntry.setDuration(duration);
            workoutEntry.setCalories(calories);
            workoutDao.save(workoutEntry);

            return new ResponseEntity<>("Entry Added", HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<List<WorkoutEntry>> getDetailsByUsername(String username,String start,String end) {
        try{
            List<WorkoutEntry> list = workoutDao.getDetailsByUsername(username,start,end);
            if (!list.isEmpty()){
                return new ResponseEntity<>(list, HttpStatus.OK);
            }else{
                return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
            }
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
