package com.example.springboot.repository;
import com.example.springboot.entity.Manufacturer;
import org.springframework.data.jpa.repository.JpaRepository;
public interface ManufacturerRepository extends JpaRepository<Manufacturer,Long> {}
