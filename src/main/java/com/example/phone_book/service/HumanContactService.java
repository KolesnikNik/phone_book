package com.example.phone_book.service;

import com.example.phone_book.domain.HumanContact;
import com.example.phone_book.domain.PhoneNumber;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface HumanContactService {


    List<HumanContact> getAll();

    List<HumanContact> addHumanContact(
            String firstName,
            String lastName,
            String midlName,
            String dateOfBirth,
            List<PhoneNumber> numbers);

    List<HumanContact> editHumanContact(
            String Id,
            String firstName,
            String lastName,
            String midlName,
            String dateOfBirth,
            List<PhoneNumber> numbers);

    List<HumanContact> findByFirstNameAndLastNameAndMidlNameOrderByFirstName(
            String firstName,
            String lastName,
            String midlName);

    List<HumanContact> findByDateOfBirthOrderByDateOfBirth(
            String dateOfBirth);

    List<HumanContact> findByFirstNameAndLastNameAndLastNameAndDateOfBirthOrderByFirstName(
            String firstName,
            String lastName,
            String midlName,
            String dateOfBirth);

}
