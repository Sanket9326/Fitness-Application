package com.Project.Fitness.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Meal {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Integer id;

    private String username;
    private String mealType;
    private String time;
    private Integer calories;
}
