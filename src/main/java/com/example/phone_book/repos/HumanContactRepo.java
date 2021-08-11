package com.example.phone_book.repos;

import com.example.phone_book.domain.HumanContact;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HumanContactRepo extends JpaRepository<HumanContact, Long> {
    HumanContact findById(String id);
    List<HumanContact> findByFirstNameOrderByFirstName();
    List<HumanContact> findByLastNameOrderByLastName();
    List<HumanContact> findByMidlNameOrderByMidlName();
    List<HumanContact> findByDateOfBirthOrderByDateOfBirth (String dateOfBirth);
    List<HumanContact> findByFirstNameAndLastNameAndMidlNameOrderByFirstName(
            String firstName,
            String lastName,
            String midlName);
    List<HumanContact> findByFirstNameAndLastNameAndLastNameAndDateOfBirthOrderByFirstName(
            String firstName,
            String lastName,
            String midlName,
            String dateOfBirth);
}
