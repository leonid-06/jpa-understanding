package com.epam.team5.repo;

import com.epam.team5.model.Company;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;


@Repository
@Transactional
public class CompanyRepoImpl extends CrudRepositoryImpl<Company, Long> implements CompanyRepo {

    public CompanyRepoImpl() {
        super(Company.class);
    }

}
