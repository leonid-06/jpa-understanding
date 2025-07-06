package com.epam.team5;

import com.epam.team5.model.Company;
import com.epam.team5.model.Employee;
import com.epam.team5.repo.CompanyRepo;
import com.epam.team5.repo.EmployeeRepo;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext("com.epam.team5");

//        CompanyRepo repo = context.getBean(CompanyRepo.class);
//
//        Company company1 = new Company("TechNova", "Berlin", "10115", "Germany");
//        Company company2 = new Company("InnoWare", "Amsterdam", "1097DN", "Netherlands");
//        Company company3 = new Company("SoftBridge", "Warsaw", "00-001", "Poland");
//
//
//        repo.save(company1);
//        repo.save(company2);
//        repo.save(company3);

        EmployeeRepo repo = context.getBean(EmployeeRepo.class);

        Employee employee1 = new Employee(
                "Doe",
                "John",
                "jdoe",
                "password123",
                "Developer",
                100000
        );

        Employee employee2 = new Employee(
                "Hahaha",
                "John",
                "jdoe",
                "password123",
                "Developer",
                100000
        );

        repo.save(employee1);
        repo.save(employee2);

    }
}
