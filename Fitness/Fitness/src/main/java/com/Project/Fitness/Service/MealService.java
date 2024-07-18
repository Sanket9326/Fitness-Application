package com.Project.Fitness.Service;

import com.Project.Fitness.Model.Meal;
import com.Project.Fitness.DAO.MealDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MealService {

    @Autowired
    LoginService loginService;

    @Autowired
    MealDao mealDao;

    public ResponseEntity<String> addMeal(String username, String mealType, String time, Integer calories) {
        try{
            if(loginService.verify(username)) {
                Meal curr = new Meal();
                curr.setUsername(username);
                curr.setMealType(mealType);
                curr.setTime(time);
                curr.setCalories(calories);
                mealDao.save(curr);
                return new ResponseEntity<>("Added Meal", HttpStatus.OK);
            }else{
                return new ResponseEntity<>("User Don't Exist", HttpStatus.UNAUTHORIZED);
            }
        }catch(Exception e){
            return new ResponseEntity<>("Error Try Again", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<List<Meal>> getMealDetails(String username) {
        try{
            if(loginService.verify(username)) {
                List<Meal> list = mealDao.getDetails(username);
                return new ResponseEntity<>(list, HttpStatus.OK);
            }else{
                return new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED);
            }
        }catch(Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<String> deleteMeal(String username, String mealType, String time) {
        try {
            if(loginService.verify(username)) {
                mealDao.deleteThisRecord(username,mealType,time);
                return new ResponseEntity<>("Deleted Meal", HttpStatus.OK);
            }else{
                return new ResponseEntity<>("User Don't Exist", HttpStatus.UNAUTHORIZED);
            }
        }catch (Exception e) {
            return new ResponseEntity<>("Error Try Again", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
