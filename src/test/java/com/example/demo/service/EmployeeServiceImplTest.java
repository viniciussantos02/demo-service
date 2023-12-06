package com.example.demo.service;

import com.example.demo.enums.PersonRole;
import com.example.demo.enums.States;
import com.example.demo.model.EmployeeBuilder;
import com.example.demo.model.Vendor;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.repository.ManagerEmployeeRepository;
import com.example.demo.repository.VendorEmployeeRepository;
import com.example.demo.rest.dto.EmployeeDTOBuilder;
import com.example.demo.rest.dto.VendorEmployeeDTO;
import com.example.demo.service.impl.EmployeeServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class EmployeeServiceImplTest {

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

    @Before
    public void contextLoads() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void createVendorEmployeeTest() {
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

    public Vendor getVendor() {
        Vendor vendor = new Vendor();
        vendor.setId(1L);
        vendor.setAge(23);
        vendor.setCity("Recife");
        vendor.setName("Carlos Santos");
        vendor.setState("PE");
        vendor.setPersonRole(2);

        return vendor;
    }

    public VendorEmployeeDTO getVendorDTO() {
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
