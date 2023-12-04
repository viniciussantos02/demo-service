package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Vendor extends Employee{

    /**
     * - Quantidade de vendas feitas por esse funcionário.
     */
    @Column(name = "employee_month_sales_quantity")
    private Long monthSalesQuantity;

    /**
     * - Bonus salarial desse funcionário referente as vendas.
     */
    @Column(name = "employee_month_salary_bonus")
    private Double monthSalaryBonus;
}
