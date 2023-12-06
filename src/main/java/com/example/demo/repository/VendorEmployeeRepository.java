package com.example.demo.repository;

import com.example.demo.model.Vendor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VendorEmployeeRepository extends JpaRepository<Vendor, Long> {
}
