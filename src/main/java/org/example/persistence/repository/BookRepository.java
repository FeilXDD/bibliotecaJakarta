package org.example.persistence.repository;


import jakarta.ejb.Stateless;
import jakarta.persistence.TypedQuery;
import org.example.persistence.entity.BookEntity;

import java.util.List;

@Stateless
public class BookRepository extends BaseRepository<BookEntity, Long> {

    public BookRepository() {
        super(BookEntity.class);
    }

    public List<BookEntity> findByTitle(String title) {
        TypedQuery<BookEntity> query = entityManager.createQuery(
                "SELECT b FROM BookEntity b WHERE b.title LIKE :title", BookEntity.class);
        query.setParameter("title", "%" + title + "%");
        return query.getResultList();
    }

    public List<BookEntity> findByAuthor(Long authorId) {
        TypedQuery<BookEntity> query = entityManager.createQuery(
                "SELECT b FROM BookEntity b WHERE b.author.id = :authorId", BookEntity.class);
        query.setParameter("authorId", authorId);
        return query.getResultList();
    }
}