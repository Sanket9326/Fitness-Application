package com.Project.Fitness.Controller;

import com.Project.Fitness.Model.WorkoutEntry;
import com.Project.Fitness.Service.WorkoutEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("workout")
public class Workout {

    @Autowired
    WorkoutEntryService workoutEntryService;

    @PutMapping("entry")
    public ResponseEntity<String> dailyWorkout(@RequestParam String username,@RequestParam String date,@RequestParam String workoutType,@RequestParam int duration,@RequestParam float calories){
        return workoutEntryService.dailyWorkout(username,date,workoutType,duration,calories);
    }

    @GetMapping("details")
    public ResponseEntity<List<WorkoutEntry>> getDetailsByUsername(@RequestParam String username,@RequestParam String startDate,@RequestParam String endDate){
        return workoutEntryService.getDetailsByUsername(username,startDate,endDate);
    }

}
