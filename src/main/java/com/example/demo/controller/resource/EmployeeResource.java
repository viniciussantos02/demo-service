package com.example.demo.controller.resource;

import com.example.demo.rest.dto.EmployeeDTO;
import com.example.demo.rest.dto.ManagerEmployeeDTO;
import com.example.demo.rest.dto.VendorEmployeeDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface EmployeeResource {

    @PostMapping("/createVendorEmployee")
    ResponseEntity<EmployeeDTO> createVendorEmployee(@RequestBody VendorEmployeeDTO vendorRequest);

    @PostMapping("/createManagerEmployee")
    ResponseEntity<EmployeeDTO> createManagerEmployee(@RequestBody ManagerEmployeeDTO managerRequest);

    @GetMapping("/getVendorEmployeeById/{id}")
    ResponseEntity<EmployeeDTO> getVendorEmployeeById(@PathVariable Long id);

    @GetMapping("/getManagerEmployeeById/{id}")
    ResponseEntity<EmployeeDTO> getManagerEmployeeById(@PathVariable Long id);

    @GetMapping("/getAllVendorEmployees")
    ResponseEntity<List<VendorEmployeeDTO>> getAllVendorEmployees();

    @GetMapping("/getAllManagerEmployees")
    ResponseEntity<List<ManagerEmployeeDTO>> getAllManagerEmployees();

    @DeleteMapping("/deleteEmployeeById/{id}")
    ResponseEntity<Void> deleteEmployeeById(@PathVariable Long id);


}
