package com.example.phone_book.controller;

import com.example.phone_book.domain.HumanContact;
import com.example.phone_book.domain.PhoneNumber;
import com.example.phone_book.service.HumanContactService;
import com.example.phone_book.service.PhoneContactService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@Controller
    public class HumanContactController {
    private final HumanContactService humanContactService;
    private final PhoneContactService phoneContactService;


    public HumanContactController(
            HumanContactService humanContactService,
            PhoneContactService phoneContactService) {
        this.humanContactService = humanContactService;
        this.phoneContactService = phoneContactService;
    }

    @GetMapping("/getAll")
    public List<HumanContact> getAll() {
        return humanContactService.getAll();
    }

    @PostMapping("/add")
    public List<HumanContact> add(String firstName,
                      String lastName,
                      String midlName,
                      String dateOfBirth,
                      List<PhoneNumber> numbers) {
        return humanContactService.addHumanContact(firstName, lastName, midlName, dateOfBirth, numbers);
    }

    @PostMapping("/edit")
    public List<HumanContact> edit(String id,
                                  String firstName,
                                  String lastName,
                                  String midlName,
                                  String dateOfBirth,
                                  List<PhoneNumber> numbers) {
        return humanContactService.editHumanContact(id, firstName, lastName, midlName, dateOfBirth, numbers);
    }

    @PostMapping("/filterFIO")
    public List<HumanContact> findByFirstNameAndLastNameAndMidlNameOrderByFirstName(
            String firstName,
            String lastName,
            String midlName){
        return humanContactService.findByFirstNameAndLastNameAndMidlNameOrderByFirstName(firstName, lastName, midlName);
    }

    @PostMapping("/filterFIO&Name")
    public List<HumanContact> findByFirstNameAndLastNameAndLastNameAndDateOfBirthOrderByFirstName(
            String firstName,
            String lastName,
            String midlName,
            String dateOfBirth) {
        return humanContactService.findByFirstNameAndLastNameAndLastNameAndDateOfBirthOrderByFirstName(firstName, lastName, midlName, dateOfBirth);
    }

    @PostMapping("/filterDateOfBirth")
    public List<HumanContact> findByDateOfBirthOrderByDateOfBirth(String dateOfBirth){
        return humanContactService.findByDateOfBirthOrderByDateOfBirth(dateOfBirth);
    }
}