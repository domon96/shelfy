package com.shelfy.controller;

import com.shelfy.model.Category;
import com.shelfy.model.Product;
import com.shelfy.model.ProductDto;
import com.shelfy.service.CategoryService;
import com.shelfy.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api")
@CrossOrigin
public class ProductController {
    private final ProductService productService;
    private final CategoryService categoryService;

    public ProductController(ProductService productService, CategoryService categoryService) {
        this.productService = productService;
        this.categoryService = categoryService;
    }

    @RequestMapping("/getProducts/{categoryId}")
    @GetMapping
    public List<Product> getProductsByCategory(@PathVariable(value = "categoryId") final int categoryId) {
        return productService.getProductsByCategory(categoryId);
    }

    @RequestMapping("/addProduct")
    @PostMapping
    public ResponseEntity<Product> addNewProduct(@RequestBody ProductDto productDto) {
        final Optional<Category> category = categoryService.getCategoryById(productDto.categoryId());
        if (category.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(productService.addProduct(productDto.name(), productDto.validDays(), category.get()));
    }
}
