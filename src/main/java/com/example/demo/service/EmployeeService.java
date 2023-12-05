package com.example.demo.service;

import com.example.demo.model.Employee;
import com.example.demo.rest.request.ManagerEmployeeRequest;
import com.example.demo.rest.request.VendorEmployeeRequest;

public interface EmployeeService {
    Employee createVendorEmployee(VendorEmployeeRequest vendorRequest);

    Employee createManagerEmployee(ManagerEmployeeRequest managerRequest);

    Employee getVendorEmployeeById(Long id);
}
