package com.example.demo.controller.resource;

import com.example.demo.model.Employee;
import com.example.demo.rest.request.ManagerEmployeeRequest;
import com.example.demo.rest.request.VendorEmployeeRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface EmployeeResource {

    @PostMapping("/createVendorEmployee")
    ResponseEntity<Employee> createVendorEmployee(@RequestBody VendorEmployeeRequest vendorRequest);

    @PostMapping("/createManagerEmployee")
    ResponseEntity<Employee> createManagerEmployee(@RequestBody ManagerEmployeeRequest managerRequest);
}
