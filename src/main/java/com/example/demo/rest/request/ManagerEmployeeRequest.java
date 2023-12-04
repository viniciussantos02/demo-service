package com.example.demo.rest.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ManagerEmployeeRequest extends EmployeeRequest {

    private String managementArea;

    /**
     * - Quantidade de pessoas que reportam a esse funcionario.
     */
    private Long subordinateQuantity;
}
