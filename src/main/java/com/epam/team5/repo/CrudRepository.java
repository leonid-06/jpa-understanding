package com.epam.team5.repo;

import com.epam.team5.model.Identifiable;

import java.util.Optional;

public interface CrudRepository<T extends Identifiable, ID> {
    T save(T entity);
    Optional<T> findById(ID id);
    void delete(T entity);
}
