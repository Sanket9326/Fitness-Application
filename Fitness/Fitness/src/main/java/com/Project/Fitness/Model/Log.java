package com.Project.Fitness.Model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Log {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(unique=true)
    private String Username;

    private String Password;
}
