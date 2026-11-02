package com.example.springboot;
import com.example.springboot.entity.Manufacturer;
import com.example.springboot.service.ManufacturerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
@Controller @RequestMapping("/manufacturers") public class ManufacturerController {
 private final ManufacturerService service;
 public ManufacturerController(ManufacturerService service){this.service=service;}
 @GetMapping public String list(Model model){model.addAttribute("manufacturers",service.findAll());return "manufacturers/list";}
 @GetMapping("/new") public String createForm(Model model){model.addAttribute("manufacturer",new Manufacturer());return "manufacturers/form";}
 @GetMapping("/{id}") public String view(@PathVariable Long id,Model model){model.addAttribute("manufacturer",service.findById(id).orElseThrow());return "manufacturers/view";}
 @GetMapping("/{id}/edit") public String edit(@PathVariable Long id,Model model){model.addAttribute("manufacturer",service.findById(id).orElseThrow());return "manufacturers/form";}
 @PostMapping("/save") public String save(@ModelAttribute Manufacturer manufacturer){service.save(manufacturer);return "redirect:/manufacturers";}
 @PostMapping("/{id}/delete") public String delete(@PathVariable Long id){service.delete(id);return "redirect:/manufacturers";}
}
