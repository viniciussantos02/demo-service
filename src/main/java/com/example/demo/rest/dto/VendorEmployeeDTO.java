package com.example.demo.rest.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VendorEmployeeDTO extends EmployeeDTO {

    /**
     * - Quantidade de vendas feitas por esse funcionário.
     */
    private Long monthSalesQuantity;

    /**
     * - Bonus salarial desse funcionário referente as vendas.
     */
    private Double monthSalaryBonus;
}
