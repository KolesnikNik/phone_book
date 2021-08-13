package com.example.phone_book.service;

import com.example.phone_book.domain.HumanContact;
import com.example.phone_book.domain.PhoneNumber;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Интерфес сервиса, отвечающего за обработку списка контактов
 * @author N.S.Kolesnik
 * @version 1.0
 */
@Service
public interface HumanContactService {

    HumanContact getById(Long id );
    /** Вывод всех контактов постранично*/
    List<HumanContact> getAllByPointsBetween(Integer lowerlimit,Integer upperlimit);
    /** Добавление нового контакта */
    List<HumanContact> addHumanContact(
            String firstName,
            String lastName,
            String midlName,
            String dateOfBirth,
            List<PhoneNumber> numbers);
    /** Изменение контакта */
    List<HumanContact> editHumanContact(
            Long Id,
            String firstName,
            String lastName,
            String midlName,
            String dateOfBirth,
            List<PhoneNumber> numbers);
    /** Поиск контакта по ФИО */
    List<HumanContact> findByFirstNameAndLastNameAndMidlNameOrderByFirstName(
            String firstName,
            String lastName,
            String midlName);
    /** Поиск контакта по дате рождения */
    List<HumanContact> findByDateOfBirthOrderByDateOfBirth(
            String dateOfBirth);
    /** Поиск контакта по ФИО и дате рождения*/
    List<HumanContact> findByFirstNameAndLastNameAndMidlNameAndDateOfBirthOrderByFirstName(
            String firstName,
            String lastName,
            String midlName,
            String dateOfBirth);

}
