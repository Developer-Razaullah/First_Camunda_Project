package com.example.workflow.service;

import org.springframework.stereotype.Component;

@Component
public class DepartmentsService {

    public String getDepartment() {
        System.out.println("Department service is called");
        return "IT Department";
    }
}
