package com.example.ch10_ex3.controller;

import com.example.ch10_ex3.dto.Country;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CountryController {

    // Rest API
    // Return Object
    @GetMapping("/france") // client 측에서 data를 가져옴
    public Country france(){
        // static 객체 호출로 DTO TEST
        Country c = Country.of("france", 67);
        return c;
    }

    // Rest API
    // Return List<Object>
    @GetMapping("/all")
    public List<Country> countries(){
        Country c1 = Country.of("korea", 1);
        Country c2 = Country.of("Japan", 2);
        return List.of(c1, c2);
    }

    @GetMapping("france/responseEntity")
    public ResponseEntity<Country> franceResponseEntity(){
        Country c = Country.of("france", 67);
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .header("continent","Europe")
                .header("capital", "Paris")
                .header("favorit_food", "cheese")
                .body(c);
    }
}
