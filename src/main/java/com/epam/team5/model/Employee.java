package com.epam.team5.model;


import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@NoArgsConstructor
public class Employee extends User {
    private String role;
    private int salary;

    public Employee(String lastName, String firstName, String username, String password, String role, int salary) {
        super(lastName, firstName, username, password);
        this.role = role;
        this.salary = salary;
    }
}
