package com.example.phone_book.domain;

import javax.persistence.*;

/**
 * Модель телефонов
 * @author N.S.Kolesnik
 * @version 1.0
 */
@Entity
@Table(name = "numbers")
public class PhoneNumber {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "number", nullable = false)
    private String number;

    public PhoneNumber() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
