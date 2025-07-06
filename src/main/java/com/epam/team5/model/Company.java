package com.epam.team5.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor
public class Company implements Identifiable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    public String name;
    public String city;
    public String zip;
    public String country;

    public Company(String name, String city, String zip, String country) {
        this.name = name;
        this.city = city;
        this.zip = zip;
        this.country = country;
    }
}
