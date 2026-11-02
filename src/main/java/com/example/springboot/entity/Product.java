package com.example.springboot.entity;
import jakarta.persistence.*;
import java.math.BigDecimal;
@Entity @Table(name="products")
public class Product {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
 @Column(nullable=false) private String name;
 @Column(nullable=false,precision=12,scale=2) private BigDecimal price;
 @ManyToOne(optional=false) @JoinColumn(name="manufacturer_id",nullable=false) private Manufacturer manufacturer;
 public Long getId(){return id;} public void setId(Long id){this.id=id;}
 public String getName(){return name;} public void setName(String name){this.name=name;}
 public BigDecimal getPrice(){return price;} public void setPrice(BigDecimal price){this.price=price;}
 public Manufacturer getManufacturer(){return manufacturer;} public void setManufacturer(Manufacturer manufacturer){this.manufacturer=manufacturer;}
}
