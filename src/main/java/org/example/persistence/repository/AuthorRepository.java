package org.example.persistence.repository;

import jakarta.ejb.Stateless;
import jakarta.persistence.TypedQuery;
import org.example.persistence.entity.AuthorEntity;

import java.util.List;

@Stateless
public class AuthorRepository extends BaseRepository<AuthorEntity, Long> {

    public AuthorRepository() {
        super(AuthorEntity.class);
    }

    public List<AuthorEntity> findByName(String name) {
        TypedQuery<AuthorEntity> query = entityManager.createQuery(
                "SELECT a FROM Author a WHERE a.name LIKE :name", AuthorEntity.class);
        query.setParameter("name", "%" + name + "%");
        return query.getResultList();
    }
}