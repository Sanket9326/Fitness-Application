package com.Project.Fitness.Controller;

import com.Project.Fitness.Service.GoalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("goal")
public class GoalController {

    @Autowired
    GoalService goalService;

    @PutMapping("set")
    public ResponseEntity<String> setGoal(@RequestParam String username,@RequestParam String goalType, @RequestParam String description, @RequestParam String startDate, @RequestParam String endDate, @RequestParam String target) {
        return goalService.setGoal(username,goalType,description,startDate,endDate,target);
    }

    @PutMapping("update")
    public ResponseEntity<String> updateGoal(@RequestParam String username,@RequestParam String goalType,@RequestParam String target,@RequestParam String description, @RequestParam String startDate, @RequestParam String endDate){
        return  goalService.updateGoal(username,goalType,target,description,startDate,endDate);
    }



}
