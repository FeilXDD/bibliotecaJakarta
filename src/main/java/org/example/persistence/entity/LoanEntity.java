package org.example.persistence.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "Loan")
public class LoanEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "user_id") // Columna foránea en la tabla Loan
    private UserEntity user;

    @ManyToOne
    @JoinColumn(name = "book_id") // Columna foránea en la tabla Loan
    private BookEntity book;

    private LocalDateTime loan_date;
    private LocalDateTime return_date;

    public LoanEntity(Integer id, UserEntity user, BookEntity book, LocalDateTime loan_date, LocalDateTime return_date) {
        this.id = id;
        this.user = user;
        this.book = book;
        this.loan_date = loan_date;
        this.return_date = return_date;
    }

    public LoanEntity() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public BookEntity getBook() {
        return book;
    }

    public void setBook(BookEntity book) {
        this.book = book;
    }

    public LocalDateTime getLoan_date() {
        return loan_date;
    }

    public void setLoan_date(LocalDateTime loan_date) {
        this.loan_date = loan_date;
    }

    public LocalDateTime getReturn_date() {
        return return_date;
    }

    public void setReturn_date(LocalDateTime return_date) {
        this.return_date = return_date;
    }
}
