package com.example.phone_book.domain;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "humans")
public class HumanContact {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "firstName", nullable = false)
    private String firstName;
    @Column(name = "lastName", nullable = false)
    private String lastName;
    private String midlName;

    public HumanContact(String firstName, String lastName, String midlName, String dateOfBirth, List<PhoneNumber> number) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.midlName = midlName;
        this.dateOfBirth = dateOfBirth;
        this.number = number;
    }

    private String dateOfBirth;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "number_id")
    private List<PhoneNumber> number;

    public HumanContact() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPatronymic() {
        return midlName;
    }

    public void setPatronymic(String patronymic) {
        this.midlName = patronymic;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public List<PhoneNumber> getNumber() {
        return number;
    }

    public void setNumber(List<PhoneNumber> number) {
        this.number = number;
    }
}
