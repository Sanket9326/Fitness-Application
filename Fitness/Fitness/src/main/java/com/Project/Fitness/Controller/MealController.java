package com.Project.Fitness.Controller;

import com.Project.Fitness.Service.LoginService;
import com.Project.Fitness.Service.MealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.Project.Fitness.Model.Meal;

import java.util.List;

@RestController
@RequestMapping("meal")
public class MealController {

    @Autowired
    MealService mealService;

    @PutMapping("add")
    public ResponseEntity<String> addMeal(@RequestParam String username,@RequestParam String mealType,@RequestParam String time,@RequestParam Integer calories) {
        return mealService.addMeal(username,mealType,time,calories);
    }
    @GetMapping("get")
    public ResponseEntity<List<Meal>> getMealDetails(@RequestParam String username) {
        return mealService.getMealDetails(username);
    }
    @DeleteMapping("delete")
    public ResponseEntity<String> deleteMeal(@RequestParam String username , @RequestParam String mealType,@RequestParam String time) {
        return mealService.deleteMeal(username,mealType,time);
    }
}
