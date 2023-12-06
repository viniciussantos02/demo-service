package com.example.demo.rest.dto;

import com.example.demo.enums.PersonRole;
import com.example.demo.enums.States;
import com.example.demo.model.Employee;
import com.example.demo.model.Manager;
import com.example.demo.model.Vendor;
import org.springframework.stereotype.Component;

@Component
public class EmployeeDTOBuilder {

    private Manager manager;
    private Vendor vendor;

    public EmployeeDTOBuilder buildWithManager(Manager manager) {
        this.manager = manager;

        return this;
    }

    public EmployeeDTOBuilder buildWithVendor(Vendor vendor) {
        this.vendor = vendor;

        return this;
    }

    public ManagerEmployeeDTO buildManagerDTO() {
        ManagerEmployeeDTO managerEmployeeDTO = new ManagerEmployeeDTO();
        buildEmployee(managerEmployeeDTO, manager);
        managerEmployeeDTO.setManagementArea(manager.getManagementArea());
        managerEmployeeDTO.setSubordinateQuantity(manager.getSubordinateQuantity());

        return managerEmployeeDTO;
    }

    public VendorEmployeeDTO buildVendorDTO() {
        VendorEmployeeDTO vendorEmployeeDTO = new VendorEmployeeDTO();
        buildEmployee(vendorEmployeeDTO, vendor);
        vendorEmployeeDTO.setMonthSalesQuantity(vendor.getMonthSalesQuantity());
        vendorEmployeeDTO.setMonthSalaryBonus(vendor.getMonthSalaryBonus());

        return vendorEmployeeDTO;
    }

    private void buildEmployee(EmployeeDTO employeeDTO, Employee employee) {
        employeeDTO.setId(employee.getId());
        employeeDTO.setName(employee.getName());
        employeeDTO.setAge(employee.getAge());
        employeeDTO.setCity(employee.getCity());
        employeeDTO.setState(States.getStateFromAcronym(employee.getState()));
        employeeDTO.setSalary(employee.getSalary());
        employeeDTO.setPhoneNumber(employee.getPhoneNumber());
        employeeDTO.setPersonRole(PersonRole.getRoleFromRoleId(employee.getPersonRole()));
    }
}