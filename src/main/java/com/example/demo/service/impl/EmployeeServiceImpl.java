package com.example.demo.service.impl;

import com.example.demo.model.Employee;
import com.example.demo.model.EmployeeBuilder;
import com.example.demo.repository.ManagerEmployeeRepository;
import com.example.demo.repository.VendorEmployeeRepository;
import com.example.demo.rest.request.ManagerEmployeeRequest;
import com.example.demo.rest.request.VendorEmployeeRequest;
import com.example.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final VendorEmployeeRepository vendorEmployeeRepository;

    private final ManagerEmployeeRepository managerEmployeeRepository;

    private EmployeeBuilder employeeBuilder;

    @Autowired
    public EmployeeServiceImpl(VendorEmployeeRepository vendorEmployeeRepository, ManagerEmployeeRepository managerEmployeeRepository, EmployeeBuilder employeeBuilder) {
        this.vendorEmployeeRepository = vendorEmployeeRepository;
        this.managerEmployeeRepository = managerEmployeeRepository;
        this.employeeBuilder = employeeBuilder;
    }

    @Override
    public Employee createVendorEmployee(VendorEmployeeRequest vendorRequest) {
        return vendorEmployeeRepository.save(employeeBuilder.buildWithVendorRequest(vendorRequest).buildVendor());
    }

    @Override
    public Employee createManagerEmployee(ManagerEmployeeRequest managerRequest) {
        return managerEmployeeRepository.save(employeeBuilder.buildWithManagerRequest(managerRequest).buildManager());
    }

    @Override
    public Employee getVendorEmployeeById(Long id) {
        return vendorEmployeeRepository.findById(id).orElse(null);
    }
}
