package com.example.demo.domain.model.dto;

import com.example.demo.domain.enums.PersonRole;
import com.example.demo.domain.enums.States;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public abstract class EmployeeDTO {

    protected Long id;
    protected String name;
    protected int age;
    protected String city;
    protected States state;
    protected Double salary;
    protected String phoneNumber;
    protected PersonRole personRole;
}
