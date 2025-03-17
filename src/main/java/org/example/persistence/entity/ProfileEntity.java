package org.example.persistence.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Profile")
public class ProfileEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String address;

    private String phoneNumber;

    public ProfileEntity(Long id, String address, String phoneNumber) {
        this.id = id;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public ProfileEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
