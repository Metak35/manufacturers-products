package com.example.springboot.service;
import com.example.springboot.entity.Product;
import com.example.springboot.repository.ProductRepository;
import org.springframework.stereotype.Service;
import java.util.*;
@Service public class ProductService {
 private final ProductRepository repo;
 public ProductService(ProductRepository repo){this.repo=repo;}
 public List<Product> findAll(){return repo.findAll();}
 public Optional<Product> findById(Long id){return repo.findById(id);}
 public Product save(Product value){return repo.save(value);}
 public void delete(Long id){repo.deleteById(id);}
}
