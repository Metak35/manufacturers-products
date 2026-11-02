package com.example.springboot;
import com.example.springboot.entity.Product;
import com.example.springboot.service.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.*;
import java.util.*;
@RestController @RequestMapping("/api/products") public class ProductApiController {
 public record ProductRequest(String name,java.math.BigDecimal price,Long manufacturerId){}
 private final ProductService service;private final ManufacturerService manufacturers;
 public ProductApiController(ProductService service,ManufacturerService manufacturers){this.service=service;this.manufacturers=manufacturers;}
 @GetMapping public List<Product> all(){return service.findAll();}
 @GetMapping("/{id}") public ResponseEntity<Product> get(@PathVariable Long id){return service.findById(id).map(ResponseEntity::ok).orElseGet(()->ResponseEntity.notFound().build());}
 @PostMapping public ResponseEntity<Product> create(@RequestBody ProductRequest req){Product p=new Product();return save(p,req,HttpStatus.CREATED);}
 @PutMapping("/{id}") public ResponseEntity<Product> update(@PathVariable Long id,@RequestBody ProductRequest req){return service.findById(id).map(p->save(p,req,HttpStatus.OK)).orElseGet(()->ResponseEntity.notFound().build());}
 private ResponseEntity<Product> save(Product p,ProductRequest req,HttpStatus status){var manufacturer=manufacturers.findById(req.manufacturerId());if(manufacturer.isEmpty()||req.name()==null||req.name().isBlank()||req.price()==null||req.price().signum()<0)return ResponseEntity.badRequest().build();p.setName(req.name());p.setPrice(req.price());p.setManufacturer(manufacturer.get());return ResponseEntity.status(status).body(service.save(p));}
 @DeleteMapping("/{id}") public ResponseEntity<Void> delete(@PathVariable Long id){if(service.findById(id).isEmpty())return ResponseEntity.notFound().build();service.delete(id);return ResponseEntity.noContent().build();}
}
