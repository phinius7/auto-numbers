package ru.interview.senchenko.autonumbers.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.interview.senchenko.autonumbers.service.NumberService;

@RestController
public class NumberRestController {

    private final NumberService numberService;

    @Autowired
    public NumberRestController(NumberService numberService) {
        this.numberService = numberService;
    }

    @GetMapping("/random")
    public String showRandomPlaneNumber() {
        return numberService.generateRandomPlateNumber();
    }

    @GetMapping("/next")
    public String showNextPlaneNumber() {
        return numberService.getNextPlateNumber();
    }
}
