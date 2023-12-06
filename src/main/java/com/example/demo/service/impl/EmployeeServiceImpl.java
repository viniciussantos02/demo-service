package com.example.demo.service.impl;

import com.example.demo.model.EmployeeBuilder;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.repository.ManagerEmployeeRepository;
import com.example.demo.repository.VendorEmployeeRepository;
import com.example.demo.rest.dto.EmployeeDTO;
import com.example.demo.rest.dto.EmployeeDTOBuilder;
import com.example.demo.rest.dto.ManagerEmployeeDTO;
import com.example.demo.rest.dto.VendorEmployeeDTO;
import com.example.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final VendorEmployeeRepository vendorEmployeeRepository;

    private final ManagerEmployeeRepository managerEmployeeRepository;

    private final EmployeeRepository employeeRepository;

    private EmployeeBuilder employeeBuilder;

    private EmployeeDTOBuilder employeeDTOBuilder;

    @Autowired
    public EmployeeServiceImpl(VendorEmployeeRepository vendorEmployeeRepository, ManagerEmployeeRepository managerEmployeeRepository, EmployeeRepository employeeRepository, EmployeeBuilder employeeBuilder,
                               EmployeeDTOBuilder employeeDTOBuilder) {
        this.vendorEmployeeRepository = vendorEmployeeRepository;
        this.managerEmployeeRepository = managerEmployeeRepository;
        this.employeeRepository = employeeRepository;
        this.employeeBuilder = employeeBuilder;
        this.employeeDTOBuilder = employeeDTOBuilder;
    }

    @Override
    public EmployeeDTO createVendorEmployee(VendorEmployeeDTO vendorRequest) {
        return employeeDTOBuilder.buildWithVendor(vendorEmployeeRepository.save(employeeBuilder.buildWithVendorDTO(vendorRequest).buildVendor())).buildVendorDTO();
    }

    @Override
    public EmployeeDTO createManagerEmployee(ManagerEmployeeDTO managerRequest) {
        return employeeDTOBuilder.buildWithManager(managerEmployeeRepository.save(employeeBuilder.buildWithManagerDTO(managerRequest).buildManager())).buildManagerDTO();
    }

    @Override
    public EmployeeDTO getVendorEmployeeById(Long id) {
        return employeeDTOBuilder.buildWithVendor(vendorEmployeeRepository.findById(id).orElse(null)).buildVendorDTO();
    }

    @Override
    public EmployeeDTO getManagerEmployeeById(Long id) {
        return employeeDTOBuilder.buildWithManager(managerEmployeeRepository.findById(id).orElse(null)).buildManagerDTO();
    }

    @Override
    public List<VendorEmployeeDTO> getAllVendorEmployees() {
        List<VendorEmployeeDTO> responseList = new ArrayList<>();

        vendorEmployeeRepository.findAll().forEach(vendor -> responseList.add(employeeDTOBuilder.buildWithVendor(vendor).buildVendorDTO()));

        return responseList;
    }

    @Override
    public List<ManagerEmployeeDTO> getAllManagerEmployees() {
        List<ManagerEmployeeDTO> responseList = new ArrayList<>();

        managerEmployeeRepository.findAll().forEach(manager -> responseList.add(employeeDTOBuilder.buildWithManager(manager).buildManagerDTO()));

        return responseList;
    }

    @Override
    public void deleteEmployeeById(Long id) {
        employeeRepository.deleteById(id);
    }
}
