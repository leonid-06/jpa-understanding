package com.epam.team5.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    public String fName;
    public String lName;
    public int experience;

    public Employee(String fName, String lName, int experience) {
        this.fName = fName;
        this.lName = lName;
        this.experience = experience;
    }
}
