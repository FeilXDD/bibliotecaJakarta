package org.example.persistence.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Book")
public class BookEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String title;

    @Column(unique = true, nullable = false, length = 50)
    private String isbn;
    private Integer publication_year;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private AuthorEntity author;

    @ManyToMany
    @JoinTable(
            name = "Book_Category", // Nombre de la tabla intermedia
            joinColumns = @JoinColumn(name = "book_id"), // Columna que referencia a Book
            inverseJoinColumns = @JoinColumn(name = "category_id") // Columna que referencia a Category
    )
    private List<CategoryEntity> categories;

    public BookEntity(Integer id, String title, String isbn, Integer publication_year, AuthorEntity author, List<CategoryEntity> categories) {
        this.id = id;
        this.title = title;
        this.isbn = isbn;
        this.publication_year = publication_year;
        this.author = author;
        this.categories = categories;
    }

    public BookEntity() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Integer getPublication_year() {
        return publication_year;
    }

    public void setPublication_year(Integer publication_year) {
        this.publication_year = publication_year;
    }

    public AuthorEntity getAuthor() {
        return author;
    }

    public void setAuthor(AuthorEntity author) {
        this.author = author;
    }

    public List<CategoryEntity> getCategories() {
        return categories;
    }

    public void setCategories(List<CategoryEntity> categories) {
        this.categories = categories;
    }
}
