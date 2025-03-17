package org.example.persistence.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import java.io.Serializable;
import java.util.List;

public class BaseRepository<T, ID> implements Serializable {
    @PersistenceContext
    protected EntityManager entityManager;

    private final Class<T> entityClass;

    protected BaseRepository(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    public T findById(ID id) {
        return entityManager.find(entityClass, id);
    }

    public List<T> findAll() {
        return entityManager.createQuery("SELECT e FROM " + entityClass.getSimpleName() + " e", entityClass).getResultList();
    }

    @Transactional
    public void save(T entity) {
        entityManager.persist(entity);
    }

    @Transactional
    public void update(T entity) {
        entityManager.merge(entity);
    }

    @Transactional
    public void delete(ID id) {
        T entity = entityManager.find(entityClass, id);
        if (entity != null) {
            entityManager.remove(entity);
        }
    }
}
