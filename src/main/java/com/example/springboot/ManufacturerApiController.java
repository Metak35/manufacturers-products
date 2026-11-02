package com.example.springboot;
import com.example.springboot.entity.Manufacturer;
import com.example.springboot.service.ManufacturerService;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.*;
import java.util.*;
@RestController @RequestMapping("/api/manufacturers") public class ManufacturerApiController {
 private final ManufacturerService service;
 public ManufacturerApiController(ManufacturerService service){this.service=service;}
 @GetMapping public List<Manufacturer> all(){return service.findAll();}
 @GetMapping("/{id}") public ResponseEntity<Manufacturer> get(@PathVariable Long id){return service.findById(id).map(ResponseEntity::ok).orElseGet(()->ResponseEntity.notFound().build());}
 @PostMapping public ResponseEntity<Manufacturer> create(@RequestBody Manufacturer value){value.setId(null);return ResponseEntity.status(201).body(service.save(value));}
 @PutMapping("/{id}") public ResponseEntity<Manufacturer> update(@PathVariable Long id,@RequestBody Manufacturer value){return service.findById(id).map(old->{old.setName(value.getName());old.setCountry(value.getCountry());return ResponseEntity.ok(service.save(old));}).orElseGet(()->ResponseEntity.notFound().build());}
 @DeleteMapping("/{id}") public ResponseEntity<Void> delete(@PathVariable Long id){if(service.findById(id).isEmpty())return ResponseEntity.notFound().build();try{service.delete(id);return ResponseEntity.noContent().build();}catch(org.springframework.dao.DataIntegrityViolationException ex){return ResponseEntity.status(409).build();}}
}
