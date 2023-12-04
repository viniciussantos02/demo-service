package com.example.demo.rest.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VendorEmployeeRequest extends EmployeeRequest {

    /**
     * - Quantidade de vendas feitas por esse funcionário.
     */
    private Long monthSalesQuantity;

    /**
     * - Bonus salarial desse funcionário referente as vendas.
     */
    private Double monthSalaryBonus;
}
