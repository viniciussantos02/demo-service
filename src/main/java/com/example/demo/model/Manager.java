package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Manager extends Employee{

    @Column(name = "employee_management_area")
    private String managementArea;

    /**
     * - Quantidade de pessoas que reportam a esse funcionario.
     */
    @Column(name = "employee_subordinate_quantity")
    private Long subordinateQuantity;
}
