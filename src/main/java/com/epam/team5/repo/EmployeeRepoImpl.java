package com.epam.team5.repo;

import com.epam.team5.model.Company;
import com.epam.team5.model.Employee;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;


@Repository
@Transactional
public class EmployeeRepoImpl extends CrudRepositoryImpl<Employee, Long> implements EmployeeRepo {

    public EmployeeRepoImpl() {
        super(Employee.class);
    }

}
