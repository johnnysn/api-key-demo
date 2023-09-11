package org.uriel.apikeydemo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @GetMapping("/public/greetings")
    public ResponseEntity<String> getPublicGreetings() {
        return ResponseEntity.ok("Greetings from a public endpoint!");
    }

    @GetMapping("/protected/greetings")
    public ResponseEntity<String> getProtectedGreetings() {
        return ResponseEntity.ok("Greetings from a protected endpoint!");
    }

}
