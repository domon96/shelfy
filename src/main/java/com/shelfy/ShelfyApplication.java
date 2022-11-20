package com.shelfy;

import com.shelfy.model.Category;
import com.shelfy.model.dto.ItemDto;
import com.shelfy.service.CategoryService;
import com.shelfy.service.ItemService;
import com.shelfy.service.ProductService;
import com.shelfy.service.ProductStatisticsService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import java.time.LocalDate;

@SpringBootApplication
public class ShelfyApplication {

    private final CategoryService categoryService;
    private final ProductService productService;
    private final ItemService itemService;
    private final ProductStatisticsService productStatisticsService;

    public ShelfyApplication(CategoryService categoryService,
                             ProductService productService,
                             ItemService itemService, ProductStatisticsService productStatisticsService) {
        this.categoryService = categoryService;
        this.productService = productService;
        this.itemService = itemService;
        this.productStatisticsService = productStatisticsService;
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

        itemService.addItem(1, LocalDate.parse("2022-11-17"), "", 3);
        itemService.addItem(18, LocalDate.parse("2023-06-20"), "Brown rice", 4);
        itemService.addItem(10, LocalDate.parse("2022-11-21"), "", 5);
        itemService.addItem(10, LocalDate.parse("2022-11-25"), "", 3);
        itemService.addItem(13, LocalDate.parse("2022-11-20"), "", 3);
        itemService.addItem(16, LocalDate.parse("2022-11-18"), "", 1);
        itemService.addItem(7, LocalDate.parse("2022-11-05"), "frozen", 1);
        itemService.addItem(15, LocalDate.parse("2022-11-28"), "", 5);
        itemService.addItem(11, LocalDate.parse("2022-11-22"), "", 2);
        itemService.addItem(2, LocalDate.parse("2022-11-19"), "", 1);

        addProductStatistics(1, "2022-10-02", true, 1);
        addProductStatistics(1, "2022-10-07", true, 1);
        addProductStatistics(1, "2022-10-19", false, 1);
        addProductStatistics(15, "2022-11-19", true, 5);
        addProductStatistics(15, "2022-10-27", false, 2);
        addProductStatistics(9, "2022-08-19", false, 3);
        addProductStatistics(10, "2022-10-30", true, 2);
        addProductStatistics(13, "2022-10-12", true, 2);
    }

    private void addProductStatistics(int id, String date, boolean wasEaten, int items) {
        productStatisticsService.addProductStatistics(new ItemDto(1, id, "", LocalDate.parse(date), "", 0, null), wasEaten, items);
    }

}
