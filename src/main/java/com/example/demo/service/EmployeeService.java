package com.example.demo.service;

import com.example.demo.rest.dto.EmployeeDTO;
import com.example.demo.rest.dto.ManagerEmployeeDTO;
import com.example.demo.rest.dto.VendorEmployeeDTO;

import java.util.List;

public interface EmployeeService {
    EmployeeDTO createVendorEmployee(VendorEmployeeDTO vendorRequest);

    EmployeeDTO createManagerEmployee(ManagerEmployeeDTO managerRequest);

    EmployeeDTO getVendorEmployeeById(Long id);

    EmployeeDTO getManagerEmployeeById(Long id);

    List<VendorEmployeeDTO> getAllVendorEmployees();

    List<ManagerEmployeeDTO> getAllManagerEmployees();

    void deleteEmployeeById(Long id);
}
