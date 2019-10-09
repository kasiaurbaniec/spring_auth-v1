package com.example.oauth2security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping(path = "/principal")
public class UserController {

    @GetMapping
    public Principal retrievePrincipal (Principal principal){
        return  principal;
    }
}
