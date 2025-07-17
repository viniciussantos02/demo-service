package com.example.demo.domain.repository;

import com.example.demo.domain.model.Vendor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VendorEmployeeRepository extends JpaRepository<Vendor, Long> {
}
