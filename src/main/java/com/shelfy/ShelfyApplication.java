package com.shelfy;

import com.shelfy.model.Category;
import com.shelfy.service.CategoryService;
import com.shelfy.service.ItemService;
import com.shelfy.service.ProductService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import java.time.Instant;

@SpringBootApplication
public class ShelfyApplication {

    private final CategoryService categoryService;
    private final ProductService productService;
    private final ItemService itemService;

    public ShelfyApplication(CategoryService categoryService,
                             ProductService productService,
                             ItemService itemService) {
        this.categoryService = categoryService;
        this.productService = productService;
        this.itemService = itemService;
    }

    public static void main(String[] args) {
        SpringApplication.run(ShelfyApplication.class, args);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void initDatabaseData() {
        final Category milkProducts = categoryService.addCategory("milk products");
        final Category meatAndFish = categoryService.addCategory("meat and fish");
        final Category fruits = categoryService.addCategory("fruits");
        final Category vegetables = categoryService.addCategory("vegetables");
        final Category grainProducts = categoryService.addCategory("grain products");
        final Category other = categoryService.addCategory("other");

        productService.addProduct("milk", 14, milkProducts);
        productService.addProduct("cheese", 14, milkProducts);
        productService.addProduct("yogurt", 14, milkProducts);

        productService.addProduct("chicken", 7, meatAndFish);
        productService.addProduct("turkey", 7, meatAndFish);
        productService.addProduct("beef", 7, meatAndFish);
        productService.addProduct("salmon", 7, meatAndFish);
        productService.addProduct("cod", 7, meatAndFish);

        productService.addProduct("banana", 5, fruits);
        productService.addProduct("apple", 5, fruits);
        productService.addProduct("grapefruit", 5, fruits);
        productService.addProduct("grapes", 5, fruits);

        productService.addProduct("carrots", 7, vegetables);
        productService.addProduct("tomatoes", 7, vegetables);
        productService.addProduct("potatoes", 7, vegetables);

        productService.addProduct("bread", 2, grainProducts);
        productService.addProduct("pasta", 30, grainProducts);
        productService.addProduct("rice", 30, grainProducts);

        itemService.addItem(1, Instant.parse("2022-11-30T18:35:24.00Z"), "Milk \"Prosto od krowy\"", 1);
        itemService.addItem(10, Instant.parse("2022-11-27T18:35:24.00Z"), "Banana from abu zabi", 1);
        itemService.addItem(18, Instant.parse("2023-03-12T18:35:24.00Z"), "Brown rice", 4);
    }

}
