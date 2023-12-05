package com.example.demo.model;

import com.example.demo.rest.request.EmployeeRequest;
import com.example.demo.rest.request.ManagerEmployeeRequest;
import com.example.demo.rest.request.VendorEmployeeRequest;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Component
public class EmployeeBuilder {

    private ManagerEmployeeRequest managerRequest;
    private VendorEmployeeRequest vendorRequest;

    public EmployeeBuilder buildWithManagerRequest(ManagerEmployeeRequest managerRequest) {
        this.managerRequest = managerRequest;

        return this;
    }

    public EmployeeBuilder buildWithVendorRequest(VendorEmployeeRequest vendorRequest) {
        this.vendorRequest = vendorRequest;

        return this;
    }

    public Manager buildManager() {
        Manager manager = new Manager();
        buildEmployee(manager, managerRequest);
        manager.setManagementArea(managerRequest.getManagementArea());
        manager.setSubordinateQuantity(managerRequest.getSubordinateQuantity());
        return manager;
    }

    public Vendor buildVendor() {
        Vendor vendor = new Vendor();
        buildEmployee(vendor, vendorRequest);
        vendor.setMonthSalesQuantity(vendorRequest.getMonthSalesQuantity());
        vendor.setMonthSalaryBonus(vendorRequest.getMonthSalaryBonus());
        return vendor;
    }

    private void buildEmployee(Employee employee, EmployeeRequest request) {
        employee.setName(request.getName());
        employee.setAge(request.getAge());
        employee.setCity(request.getCity());
        employee.setState(request.getState().getAcronym());
        employee.setSalary(request.getSalary());
        employee.setPhoneNumber(request.getPhoneNumber());
        employee.setPersonRole(request.getPersonRole().getRoleId());
        employee.setInsertionDate(Timestamp.valueOf(LocalDateTime.now()));
    }
}