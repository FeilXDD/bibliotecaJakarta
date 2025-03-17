package org.example.persistence.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "User")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String email;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "profile_id") // Columna foránea en la tabla User
    private ProfileEntity profile;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<LoanEntity> loans;

    public UserEntity(Long id, String name, String email, ProfileEntity profile, List<LoanEntity> loans) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.profile = profile;
        this.loans = loans;
    }

    public UserEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ProfileEntity getProfile() {
        return profile;
    }

    public void setProfile(ProfileEntity profile) {
        this.profile = profile;
    }

    public List<LoanEntity> getLoans() {
        return loans;
    }

    public void setLoans(List<LoanEntity> loans) {
        this.loans = loans;
    }
}
