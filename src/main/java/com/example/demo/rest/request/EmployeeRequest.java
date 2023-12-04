package com.example.demo.rest.request;

import com.example.demo.enums.PersonRole;
import com.example.demo.enums.States;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public abstract class EmployeeRequest {

    protected Long id;
    protected String name;
    protected int age;
    protected String city;
    protected States state;
    protected Double salary;
    protected String phoneNumber;
    protected PersonRole personRole;
}
