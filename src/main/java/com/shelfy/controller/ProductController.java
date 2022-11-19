package com.shelfy.controller;

import com.shelfy.model.Product;
import com.shelfy.service.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping("/getProducts/{categoryId}")
    @GetMapping
    public List<Product> getProducts(@PathVariable(value = "categoryId") final int categoryId) {
        return productService.getProductsByCategory(categoryId);
    }

}
