package org.example.service;


import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import org.example.persistence.entity.AuthorEntity;
import org.example.persistence.repository.AuthorRepository;

import java.util.List;

@Stateless
public class AuthorService {

    @Inject
    private AuthorRepository authorRepository;

    public List<AuthorEntity> getAllAuthors() {
        return authorRepository.findAll();
    }

    public AuthorEntity getAuthorById(Long id) {
        return authorRepository.findById(id);
    }

    public void createAuthor(AuthorEntity author) {
        authorRepository.save(author);
    }

    public void updateAuthor(AuthorEntity author) {
        authorRepository.update(author);
    }

    public void deleteAuthor(Long id) {
        authorRepository.delete(id);
    }
}
