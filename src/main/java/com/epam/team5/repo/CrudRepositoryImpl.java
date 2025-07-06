package com.epam.team5.repo;

import com.epam.team5.model.Identifiable;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import lombok.Setter;

import java.util.Optional;

@Transactional
public abstract class CrudRepositoryImpl<T extends Identifiable, ID> implements CrudRepository<T, ID> {

    protected EntityManager em;
    private final Class<T> clazz;

    protected CrudRepositoryImpl(Class<T> clazz) {
        this.clazz = clazz;
    }

    @PersistenceContext
    public void setEm(EntityManager em) {
        this.em = em;
    }

    @Override
    public T save(T entity){

        if (entity.getId() == null) {
            em.persist(entity);
            return entity;
        } else {
            return em.merge(entity);
        }
    }

    @Override
    public Optional<T> findById(ID id){
        T saved = em.find(clazz, id);
        return Optional.ofNullable(saved);
    }

    @Override
    public void delete(T entity){
        em.remove(entity);
    }

}
