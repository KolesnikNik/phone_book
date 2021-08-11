package com.example.phone_book.service;

import com.example.phone_book.domain.HumanContact;
import com.example.phone_book.domain.PhoneNumber;
import com.example.phone_book.repos.HumanContactRepo;
import com.example.phone_book.repos.PhoneNumberRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HumanContactServiceImpl implements HumanContactService {
    private final HumanContactRepo humanContactRepo;
    private final PhoneNumberRepo phoneNumberRepo;

    List<HumanContact> humans;

    public HumanContactServiceImpl(
            HumanContactRepo humanContactRepo,
            PhoneNumberRepo phoneNumberRepo) {
        this.humanContactRepo = humanContactRepo;
        this.phoneNumberRepo = phoneNumberRepo;
    }


    @Override
    public List<HumanContact> getAll() {
        humans = humanContactRepo.findAll();
        return humans;
    }

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

    @Override
    public List<HumanContact> editHumanContact(
            String id,
            String firstName,
            String lastName,
            String midlName,
            String dateOfBirth,
            List<PhoneNumber> numbers) {
        if (id != null) {
            HumanContact human = humanContactRepo.findById(id);
            human = new HumanContact(firstName, lastName, midlName, dateOfBirth, numbers);
            humanContactRepo.save(human);
        }
        humans = humanContactRepo.findAll();
        return humans;
    }

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

    @Override
    public List<HumanContact> findByFirstNameAndLastNameAndLastNameAndDateOfBirthOrderByFirstName(
            String firstName,
            String lastName,
            String midlName,
            String dateOfBirth) {
        if (firstName != null && !firstName.isEmpty()
            && lastName != null && !lastName.isEmpty()
            && midlName != null && !midlName.isEmpty()
            && dateOfBirth != null && !dateOfBirth.isEmpty()) {

        humans = humanContactRepo.findByFirstNameAndLastNameAndLastNameAndDateOfBirthOrderByFirstName(
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
