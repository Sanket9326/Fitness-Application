package com.Project.Fitness.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class MotivationalQuotes {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String dayOfWeek;
    private String quote;
}
