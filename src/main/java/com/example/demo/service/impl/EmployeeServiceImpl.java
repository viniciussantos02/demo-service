package com.example.demo.service.impl;

import com.example.demo.model.Employee;
import com.example.demo.model.EmployeeBuilder;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.rest.request.ManagerEmployeeRequest;
import com.example.demo.rest.request.VendorEmployeeRequest;
import com.example.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    private EmployeeBuilder employeeBuilder;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository, EmployeeBuilder employeeBuilder) {
        this.employeeRepository = employeeRepository;
        this.employeeBuilder = employeeBuilder;
    }

    @Override
    public Employee createVendorEmployee(VendorEmployeeRequest vendorRequest) {
        return employeeRepository.save(employeeBuilder.buildWithVendorRequest(vendorRequest).buildVendor());
    }

    @Override
    public Employee createManagerEmployee(ManagerEmployeeRequest managerRequest) {
        return employeeRepository.save(employeeBuilder.buildWithManagerRequest(managerRequest).buildManager());
    }
}
