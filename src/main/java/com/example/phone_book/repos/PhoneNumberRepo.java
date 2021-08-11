package com.example.phone_book.repos;

import com.example.phone_book.domain.PhoneNumber;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Интерфес репозитория списка телефонов
 * @author N.S.Kolesnik
 * @version 1.0
 */
public interface PhoneNumberRepo extends JpaRepository<PhoneNumber, Long> {
    List<PhoneNumber> findByNumber();
}
