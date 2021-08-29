package ru.geekbrains.avbugorov.hw11.SpringSecurity.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.geekbrains.avbugorov.hw11.SpringSecurity.entities.User;
import ru.geekbrains.avbugorov.hw11.SpringSecurity.services.UserService;

import java.security.Principal;

@RestController
@RequiredArgsConstructor
public class TestController {
    private final UserService userService;

    @GetMapping("/")
    public String homePage() {
        return "My home page";
    }

    @GetMapping("/user_info")
    public String daoTestPage(Principal principal) {
        User user = userService.findByUserName(principal.getName()).orElseThrow(() -> new RuntimeException("Unable to find user by username: " + principal.getName()));
        return "Authenticated user info: " + user.getUserName() + " : " + user.getEmail();
    }

    @GetMapping("/secret_page")
    public String secretPage() {
        return "This is a secret page";
    }
}
