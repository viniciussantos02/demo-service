package com.example.demo.rest.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ManagerEmployeeDTO extends EmployeeDTO {

    private String managementArea;

    /**
     * - Quantidade de pessoas que reportam a esse funcionario.
     */
    private Long subordinateQuantity;
}
