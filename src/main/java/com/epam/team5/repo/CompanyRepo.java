package com.epam.team5.repo;

import com.epam.team5.model.Company;

import java.util.Optional;

public interface CompanyRepo extends CrudRepository<Company, Long> {
//    Optional<Company> findByName(String name);
}
