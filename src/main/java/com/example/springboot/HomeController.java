package com.example.springboot;
import com.example.springboot.service.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
@Controller public class HomeController {
 private final ManufacturerService manufacturers; private final ProductService products;
 public HomeController(ManufacturerService manufacturers,ProductService products){this.manufacturers=manufacturers;this.products=products;}
 @GetMapping("/") public String home(Model model){model.addAttribute("manufacturers",manufacturers.findAll());model.addAttribute("products",products.findAll());return "index";}
}
