package com.tts.ecommerce.controllers;

import javax.validation.Valid;

import com.tts.ecommerce.models.Product;
import com.tts.ecommerce.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ProductController {
        @Autowired
        ProductService productService;
 
        @GetMapping("/product/{id}")
        public String show(@PathVariable Long id, Model model) {
            Product product = productService.findById(id);
            model.addAttribute(product);
            return "product";
        }
 
        // TODO: Either implement admin controls or remove these methods.
 
        @RequestMapping(value = "/product", method = {RequestMethod.POST, RequestMethod.PUT})
        public String createOrUpdate(@Valid Product product) {
            productService.save(product);
            return "redirect:/product/" + product.getId();
        }
    }


