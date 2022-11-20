package com.shelfy.controller;

import com.shelfy.model.dto.ProductStatisticDto;
import com.shelfy.service.ProductStatisticService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/api")
public class ProductStatisticController {
    private final ProductStatisticService productStatisticService;

    public ProductStatisticController(ProductStatisticService productStatisticService) {
        this.productStatisticService = productStatisticService;
    }

    @RequestMapping("/statistics")
    @GetMapping
    public List<ProductStatisticDto> summarize(){
        return productStatisticService.summarizeProductStatistic();
    }
}
