package com.example.springboot;
import com.example.springboot.entity.Product;
import com.example.springboot.service.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
@Controller @RequestMapping("/products") public class ProductController {
 private final ProductService service;private final ManufacturerService manufacturers;
 public ProductController(ProductService service,ManufacturerService manufacturers){this.service=service;this.manufacturers=manufacturers;}
 @GetMapping public String list(Model model){model.addAttribute("products",service.findAll());return "products/list";}
 @GetMapping("/new") public String create(Model model){model.addAttribute("product",new Product());model.addAttribute("manufacturers",manufacturers.findAll());return "products/form";}
 @GetMapping("/{id}") public String view(@PathVariable Long id,Model model){model.addAttribute("product",service.findById(id).orElseThrow());return "products/view";}
 @GetMapping("/{id}/edit") public String edit(@PathVariable Long id,Model model){model.addAttribute("product",service.findById(id).orElseThrow());model.addAttribute("manufacturers",manufacturers.findAll());return "products/form";}
 @PostMapping("/save") public String save(@ModelAttribute Product product,@RequestParam Long manufacturerId){product.setManufacturer(manufacturers.findById(manufacturerId).orElseThrow());service.save(product);return "redirect:/products";}
 @PostMapping("/{id}/delete") public String delete(@PathVariable Long id){service.delete(id);return "redirect:/products";}
}
