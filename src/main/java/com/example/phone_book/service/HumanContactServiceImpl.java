package com.example.phone_book.service;

import com.example.phone_book.domain.HumanContact;
import com.example.phone_book.domain.PhoneNumber;
import com.example.phone_book.repos.HumanContactRepo;
import com.example.phone_book.repos.PhoneNumberRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 * Сервис, отвечающий за обработку списка контактов
 * @author N.S.Kolesnik
 * @version 1.0
 */
@Service
public class HumanContactServiceImpl implements HumanContactService {

    private final HumanContactRepo humanContactRepo;
    private final PhoneNumberRepo phoneNumberRepo;

    List<HumanContact> humans;


    @Autowired
    public HumanContactServiceImpl(
            HumanContactRepo humanContactRepo,
            PhoneNumberRepo phoneNumberRepo) {
        this.humanContactRepo = humanContactRepo;
        this.phoneNumberRepo = phoneNumberRepo;
    }

    @Override
    public HumanContact getById(Long id) {
        HumanContact human = humanContactRepo.getById(id);
        return human;
    }

    /** Вывод всех контактов постранично */
    @Override
    public List<HumanContact> getAllByPointsBetween(Integer lowerlimit,Integer upperlimit) {
        humans = humanContactRepo.findAll();
        return humans;
    }
    /** Добавление нового контакта */
    @Override
    public List<HumanContact> addHumanContact(
            String firstName,
            String lastName,
            String midlName,
            String dateOfBirth,
            List<PhoneNumber> numbers) {
        HumanContact human = new HumanContact(firstName, lastName, midlName, dateOfBirth, numbers);
        humanContactRepo.save(human);
        humans = humanContactRepo.findAll();
        return humans;
    }
    /** Изменение контакта */
    @Override
    public List<HumanContact> editHumanContact(
            Long id,
            String firstName,
            String lastName,
            String midlName,
            String dateOfBirth,
            List<PhoneNumber> numbers) {
        HumanContact human;
        if (humanContactRepo.getById(id) == null) {
            human = new HumanContact(firstName, lastName, midlName, dateOfBirth, numbers);
            humanContactRepo.save(human);
        }
        humans = humanContactRepo.findAll();
        return humans;
    }
    /** Поиск контакта по ФИО */
    @Override
    public List<HumanContact> findByFirstNameAndLastNameAndMidlNameOrderByFirstName(
            String firstName,
            String lastName,
            String midlName) {
        if (firstName != null && !firstName.isEmpty()
                && lastName != null && !lastName.isEmpty()
                && midlName != null && !midlName.isEmpty()) {

            humans = humanContactRepo.findByFirstNameAndLastNameAndMidlNameOrderByFirstName(firstName, lastName, midlName);
        } else {
            humans = humanContactRepo.findAll();
        }
        return humans;
    }
    /** Поиск контакта по дате рождения */
    @Override
    public List<HumanContact> findByDateOfBirthOrderByDateOfBirth(
            String dateOfBirth) {
        if (dateOfBirth != null && !dateOfBirth.isEmpty()) {
            humans = humanContactRepo.findByDateOfBirthOrderByDateOfBirth(dateOfBirth);
        } else {
            humans = humanContactRepo.findAll();
        }
        return humans;
    }
    /** Поиск контакта по ФИО и дате рождения*/
    @Override
    public List<HumanContact> findByFirstNameAndLastNameAndMidlNameAndDateOfBirthOrderByFirstName(
            String firstName,
            String lastName,
            String midlName,
            String dateOfBirth) {
        if (firstName != null && !firstName.isEmpty()
                && lastName != null && !lastName.isEmpty()
                && midlName != null && !midlName.isEmpty()
                && dateOfBirth != null && !dateOfBirth.isEmpty()) {

            humans = humanContactRepo.findByFirstNameAndLastNameAndMidlNameAndDateOfBirthOrderByFirstName(
                    firstName,
                    lastName,
                    midlName,
                    dateOfBirth);
        } else {
            humans = humanContactRepo.findAll();
        }
        return humans;
    }


}
