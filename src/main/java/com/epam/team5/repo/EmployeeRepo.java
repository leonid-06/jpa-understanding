package com.epam.team5.repo;

import com.epam.team5.model.Employee;

public interface EmployeeRepo extends CrudRepository<Employee, Long> {
//    Optional<Company> findByName(String name);
}
