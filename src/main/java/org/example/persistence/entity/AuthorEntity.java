package org.example.persistence.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "Author")
public class AuthorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String name;
    private LocalDateTime birth_date;
    private String nationality;

    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<BookEntity> books;

    public AuthorEntity(Integer id, String name, LocalDateTime birth_date, String nationality, List<BookEntity> books) {
        this.id = id;
        this.name = name;
        this.birth_date = birth_date;
        this.nationality = nationality;
        this.books = books;
    }

    public AuthorEntity() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getBirth_date() {
        return birth_date;
    }

    public void setBirth_date(LocalDateTime birth_date) {
        this.birth_date = birth_date;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public List<BookEntity> getBooks() {
        return books;
    }

    public void setBooks(List<BookEntity> books) {
        this.books = books;
    }
}
