package com.shelfy.repository;

import com.shelfy.model.ProductStatistic;
import com.shelfy.model.dto.ProductStatisticDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductStatisticRepository extends JpaRepository<ProductStatistic, Integer> {
    @Query("SELECT SUM(p.wastedQuantity), SUM(p.eatenQuantity), p.product.name FROM ProductStatistic p GROUP BY p.id")
    List<ProductStatisticDto> findByGroupedByProduct();
}