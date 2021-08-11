package com.example.phone_book.repos;

import com.example.phone_book.domain.HumanContact;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Интерфес репозитория списка контактов
 * @author N.S.Kolesnik
 * @version 1.0
 */
public interface HumanContactRepo extends JpaRepository<HumanContact, Long> {
    /** Поиск по id */
    HumanContact getById(Long id);
    /** Поиск по дате рождения */
    List<HumanContact> findByDateOfBirthOrderByDateOfBirth (String dateOfBirth);
    /** Поиск по ФИО */
    List<HumanContact> findByFirstNameAndLastNameAndMidlNameOrderByFirstName(
            String firstName,
            String lastName,
            String midlName);
    /** Поиск по ФИО и дате рождения */
    List<HumanContact> findByFirstNameAndLastNameAndMidlNameAndDateOfBirthOrderByFirstName(
            String firstName,
            String lastName,
            String midlName,
            String dateOfBirth);
}
