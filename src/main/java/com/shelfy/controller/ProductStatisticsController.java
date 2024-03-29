package com.shelfy.controller;

import com.shelfy.model.dto.ProductStatisticsDto;
import com.shelfy.service.ProductStatisticsService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(path = "/api")
public class ProductStatisticsController {
    private final ProductStatisticsService productStatisticsService;

    public ProductStatisticsController(ProductStatisticsService productStatisticsService) {
        this.productStatisticsService = productStatisticsService;
    }

    @RequestMapping("/statistics")
    @GetMapping
    public List<ProductStatisticsDto> summarize() {
        return productStatisticsService.summarizeProductStatistics();
    }
}