package com.example.oauth2security.service;

import com.example.oauth2security.model.Employee;
import com.example.oauth2security.repositories.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeRepository repository;

    public EmployeeService(EmployeeRepository repository) {
        this.repository = repository;
    }

    public List<Employee> showEmplyees(){
        return repository.findAll();
    }
}
