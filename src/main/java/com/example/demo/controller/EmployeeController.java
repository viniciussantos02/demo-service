package com.example.demo.controller;

import com.example.demo.controller.resource.EmployeeResource;
import com.example.demo.model.Employee;
import com.example.demo.rest.request.ManagerEmployeeRequest;
import com.example.demo.rest.request.VendorEmployeeRequest;
import com.example.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
public class EmployeeController implements EmployeeResource {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public ResponseEntity<Employee> createVendorEmployee(VendorEmployeeRequest vendorRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(employeeService.createVendorEmployee(vendorRequest));
    }

    @Override
    public ResponseEntity<Employee> createManagerEmployee(ManagerEmployeeRequest managerRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(employeeService.createManagerEmployee(managerRequest));
    }

    @Override
    public ResponseEntity<Employee> getVendorEmployeeById(Long id) {
        return ResponseEntity.ok(employeeService.getVendorEmployeeById(id));
    }
}
