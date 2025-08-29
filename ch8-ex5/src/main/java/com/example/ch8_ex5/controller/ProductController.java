package com.example.ch8_ex5.controller;

import com.example.ch8_ex5.domain.Product;
import com.example.ch8_ex5.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping("/products")
    public String viewProducts(Model model){
        List<Product> products = productService.findAll();
        model.addAttribute("prducts", products);

        return "products.html";
    }

    @RequestMapping(path = "/products", method = RequestMethod.POST)
    public String addProduct(
            @RequestParam String name,
            @RequestParam double price,
            Model model
    ) {
        Product p = new Product();
        p.setName(name);
        p.setPrice(price);
        productService.addProduct(p);

        List<Product> products = productService.findAll();

        model.addAttribute("products", products);
        return "products.html";
    }


}
