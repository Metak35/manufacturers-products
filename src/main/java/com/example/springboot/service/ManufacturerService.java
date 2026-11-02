package com.example.springboot.service;
import com.example.springboot.entity.Manufacturer;
import com.example.springboot.repository.ManufacturerRepository;
import org.springframework.stereotype.Service;
import java.util.*;
@Service public class ManufacturerService {
 private final ManufacturerRepository repo;
 public ManufacturerService(ManufacturerRepository repo){this.repo=repo;}
 public List<Manufacturer> findAll(){return repo.findAll();}
 public Optional<Manufacturer> findById(Long id){return repo.findById(id);}
 public Manufacturer save(Manufacturer value){return repo.save(value);}
 public void delete(Long id){repo.deleteById(id);}
}
