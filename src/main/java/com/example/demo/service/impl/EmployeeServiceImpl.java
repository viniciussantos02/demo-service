package com.example.demo.service.impl;

import com.example.demo.domain.model.EmployeeBuilder;
import com.example.demo.domain.repository.EmployeeRepository;
import com.example.demo.domain.repository.ManagerEmployeeRepository;
import com.example.demo.domain.repository.VendorEmployeeRepository;
import com.example.demo.domain.model.dto.EmployeeDTO;
import com.example.demo.domain.model.dto.EmployeeDTOBuilder;
import com.example.demo.domain.model.dto.ManagerEmployeeDTO;
import com.example.demo.domain.model.dto.VendorEmployeeDTO;
import com.example.demo.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final VendorEmployeeRepository vendorEmployeeRepository;

    private final ManagerEmployeeRepository managerEmployeeRepository;

    private final EmployeeRepository employeeRepository;

    private final EmployeeBuilder employeeBuilder;

    private final EmployeeDTOBuilder employeeDTOBuilder;

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
