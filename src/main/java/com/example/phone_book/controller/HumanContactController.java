package com.example.phone_book.controller;

import com.example.phone_book.domain.HumanContact;
import com.example.phone_book.domain.PhoneNumber;
import com.example.phone_book.service.HumanContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

/**
 * Контроллер отвечающий за работу с контактами
 * @author N.S.Kolesnik
 * @version 1.0
 */
@Controller
public class HumanContactController {
    private final HumanContactService humanContactService;

    @Autowired
    public HumanContactController(
            HumanContactService humanContactService) {
        this.humanContactService = humanContactService;
    }
    /**
     * Контроллер вывода всех контактов
     * @param lowerlimit - начальный диапазон соответствует upperlimit+1 предыдущей страницы,
     * для первой страницы это 0;
     * @param upperlimit - конечный диапазон диапазон соответствует lowerlimit + 100.
     */
    @GetMapping("/getAll")
    public List<HumanContact> getAllByPointsBetween(Integer lowerlimit,Integer upperlimit) {
        return humanContactService.getAllByPointsBetweenSer(lowerlimit,upperlimit);
    }

    /** Контроллер добавления контакта */
    @PostMapping("/add")
    public List<HumanContact> add(String firstName,
                                  String lastName,
                                  String midlName,
                                  String dateOfBirth,
                                  List<PhoneNumber> numbers) {
        return humanContactService.addHumanContact(firstName, lastName, midlName, dateOfBirth, numbers);
    }

    /** Контроллер изменения контакта */
    @PostMapping("/edit")
    public List<HumanContact> edit(Long id,
                                   String firstName,
                                   String lastName,
                                   String midlName,
                                   String dateOfBirth,
                                   List<PhoneNumber> numbers) {
    return humanContactService.editHumanContact(id, firstName, lastName, midlName, dateOfBirth, numbers);
    }

    /** Контроллер вывода по ФИО */
    @PostMapping("/filterFIO")
    public List<HumanContact> findByFirstNameAndLastNameAndMidlNameOrderByFirstName(
            String firstName,
            String lastName,
            String midlName) {
        return humanContactService.findByFirstNameAndLastNameAndMidlNameOrderByFirstName(firstName, lastName, midlName);
    }

    /** Контроллер вывода по ФИО и дате рождения */
    @PostMapping("/filterFIO&DateOfBirth")
    public List<HumanContact> findByFirstNameAndLastNameAndMidlNameAndDateOfBirthOrderByFirstName(
            String firstName,
            String lastName,
            String midlName,
            String dateOfBirth) {
        return humanContactService.findByFirstNameAndLastNameAndMidlNameAndDateOfBirthOrderByFirstName(firstName, lastName, midlName, dateOfBirth);
    }

    /** Контроллер вывода по дате рождения */
    @PostMapping("/filterDateOfBirth")
    public List<HumanContact> findByDateOfBirthOrderByDateOfBirth(String dateOfBirth) {
        return humanContactService.findByDateOfBirthOrderByDateOfBirth(dateOfBirth);
    }
}