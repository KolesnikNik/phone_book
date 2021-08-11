package com.example.phone_book.service;

import com.example.phone_book.domain.PhoneNumber;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public interface PhoneContactService {

    String addPhoneNumber(
            String number);

    String findByNumber(
            String number);
}
