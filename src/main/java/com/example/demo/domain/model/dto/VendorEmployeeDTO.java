package com.example.demo.domain.model.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
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
