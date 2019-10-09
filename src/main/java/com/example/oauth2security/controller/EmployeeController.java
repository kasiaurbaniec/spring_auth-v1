package com.example.oauth2security.controller;

import com.example.oauth2security.model.Employee;
import com.example.oauth2security.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/employees")
public class EmployeeController {

    @Autowired
    EmployeeService service;

    @GetMapping(path = "/", produces = "application/json")
    public List<Employee> getEmployee(){
        return service.showEmplyees();
    }


}
