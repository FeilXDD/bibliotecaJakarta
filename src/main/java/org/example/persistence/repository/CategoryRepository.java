package org.example.persistence.repository;

import jakarta.ejb.Stateless;
import jakarta.persistence.TypedQuery;
import org.example.persistence.entity.CategoryEntity;

import java.util.List;

@Stateless
public class CategoryRepository extends BaseRepository<CategoryEntity, Long>{

    public CategoryRepository() {
        super(CategoryEntity.class);
    }

    public List<CategoryEntity> findByName(String name) {
        TypedQuery<CategoryEntity> query = entityManager.createQuery(
                "SELECT c FROM Category c WHERE c.name LIKE :name", CategoryEntity.class);
        query.setParameter("name", "%" + name + "%");
        return query.getResultList();
    }
}
