package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;

@Entity
@Table(name = "employee")
@Getter
@Setter
@DiscriminatorValue("not null")
public abstract class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id")
    protected Long id;

    @Column(name = "employee_name")
    protected String name;

    @Column(name = "employee_age")
    protected int age;

    @Column(name = "employee_city")
    protected String city;

    @Column(name = "employee_state")
    protected String state;

    @Column(name = "employee_salary")
    protected Double salary;

    @Column(name = "employee_phone_number")
    protected String phoneNumber;

    @Column(name = "person_role")
    protected int personRole;

    @Column(name = "employee_insertion_date")
    protected Timestamp insertionDate;
}
