package com.driver.controller;

import com.driver.services.AuthorService;
import com.driver.models.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/author")
public class AuthorController {

    @Autowired
    AuthorService authorService;

    @PostMapping("/")
    public ResponseEntity createAuthor(@RequestBody Author author){

        authorService.create(author);
        return new ResponseEntity<>("the author is successfully added to the system", HttpStatus.CREATED);
    }
}
