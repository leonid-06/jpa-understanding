package com.epam.team5;

import com.epam.team5.model.Company;
import com.epam.team5.model.Employee;
import com.epam.team5.model.Salary;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ) {

        try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("maipu")) {
            EntityManager em = emf.createEntityManager();
            em.getTransaction().begin();
            Employee employee1 = new Employee("Leonid", "Kharin", 2);
            Employee employee2 = new Employee("Vasyl", "Ponomarenko", 3);

            Company company = new Company("Google", "Los-Angeles", "09123", "USA");

            Salary salary = new Salary(company, Salary.Level.JUNIOR);

            em.persist(employee1);
            em.persist(employee2);
            em.persist(salary);
            em.persist(company);

            em.getTransaction().commit();
            em.close();
        }
    }
}
