package com.example.demo.controller;

import com.example.demo.controller.resource.EmployeeResource;
import com.example.demo.rest.dto.EmployeeDTO;
import com.example.demo.rest.dto.ManagerEmployeeDTO;
import com.example.demo.rest.dto.VendorEmployeeDTO;
import com.example.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController implements EmployeeResource {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public ResponseEntity<EmployeeDTO> createVendorEmployee(VendorEmployeeDTO vendorRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(employeeService.createVendorEmployee(vendorRequest));
    }

    @Override
    public ResponseEntity<EmployeeDTO> createManagerEmployee(ManagerEmployeeDTO managerRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(employeeService.createManagerEmployee(managerRequest));
    }

    @Override
    public ResponseEntity<EmployeeDTO> getVendorEmployeeById(Long id) {
        return ResponseEntity.ok(employeeService.getVendorEmployeeById(id));
    }

    @Override
    public ResponseEntity<EmployeeDTO> getManagerEmployeeById(Long id) {
        return ResponseEntity.ok(employeeService.getManagerEmployeeById(id));
    }

    @Override
    public ResponseEntity<List<VendorEmployeeDTO>> getAllVendorEmployees() {
        return ResponseEntity.ok(employeeService.getAllVendorEmployees());
    }

    @Override
    public ResponseEntity<List<ManagerEmployeeDTO>> getAllManagerEmployees() {
        return ResponseEntity.ok(employeeService.getAllManagerEmployees());
    }

    @Override
    public ResponseEntity<Void> deleteEmployeeById(Long id) {
        employeeService.deleteEmployeeById(id);

        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
