package com.example.demo.service;

import com.example.demo.domain.enums.PersonRole;
import com.example.demo.domain.enums.States;
import com.example.demo.domain.model.EmployeeBuilder;
import com.example.demo.domain.model.Vendor;
import com.example.demo.domain.repository.EmployeeRepository;
import com.example.demo.domain.repository.ManagerEmployeeRepository;
import com.example.demo.domain.repository.VendorEmployeeRepository;
import com.example.demo.domain.model.dto.EmployeeDTOBuilder;
import com.example.demo.domain.model.dto.VendorEmployeeDTO;
import com.example.demo.service.impl.EmployeeServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class EmployeeServiceImplTest {

    @Mock
    private VendorEmployeeRepository vendorEmployeeRepository;

    @Mock
    private ManagerEmployeeRepository managerEmployeeRepository;

    @Mock
    private EmployeeRepository employeeRepository;

    @Mock
    private EmployeeBuilder employeeBuilder;

    @Mock
    private EmployeeDTOBuilder employeeDTOBuilder;

    @InjectMocks
    private EmployeeServiceImpl employeeService;

    @BeforeEach
    void contextLoads() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void createVendorEmployeeTest() {
        Vendor vendor = getVendor();

        VendorEmployeeDTO vendorEmployeeDTO = getVendorDTO();

        EmployeeBuilder employeeBuilder = new EmployeeBuilder();
        employeeBuilder.buildWithVendorDTO(vendorEmployeeDTO);

        when(vendorEmployeeRepository.save(any(Vendor.class))).thenReturn(vendor);
        when(this.employeeBuilder.buildWithVendorDTO(vendorEmployeeDTO)).thenReturn(employeeBuilder);

        EmployeeDTOBuilder employeeDTOBuilder = new EmployeeDTOBuilder();
        employeeDTOBuilder.buildWithVendor(vendor);

        when(this.employeeDTOBuilder.buildWithVendor(vendor)).thenReturn(employeeDTOBuilder);

        VendorEmployeeDTO response = (VendorEmployeeDTO) employeeService.createVendorEmployee(vendorEmployeeDTO);

        assertEquals(vendorEmployeeDTO.getPersonRole(), response.getPersonRole());
        assertEquals(vendorEmployeeDTO.getState(), response.getState());
    }

    private Vendor getVendor() {
        Vendor vendor = new Vendor();
        vendor.setId(1L);
        vendor.setAge(23);
        vendor.setCity("Recife");
        vendor.setName("Carlos Santos");
        vendor.setState("PE");
        vendor.setPersonRole(2);

        return vendor;
    }

    private VendorEmployeeDTO getVendorDTO() {
        VendorEmployeeDTO vendorDTO = new VendorEmployeeDTO();
        vendorDTO.setId(1L);
        vendorDTO.setAge(23);
        vendorDTO.setCity("Recife");
        vendorDTO.setName("Carlos Santos");
        vendorDTO.setState(States.PERNAMBUCO);
        vendorDTO.setPersonRole(PersonRole.VENDOR);

        return vendorDTO;
    }
}
