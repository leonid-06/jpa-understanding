package com.epam.team5.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor
public class Salary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    @ManyToOne
    @JoinColumn(name = "company_id")
    public Company company;
    @Enumerated(EnumType.STRING)
    public Level level;

    public enum Level {
        JUNIOR, MIDDLE, SENIOR, ARCHITECT
    }

    public Salary(Company company, Level level) {
        this.company = company;
        this.level = level;
    }
}


