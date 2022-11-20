package com.shelfy.repository;

import com.shelfy.model.ProductStatistics;
import com.shelfy.model.dto.ProductStatisticsDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductStatisticsRepository extends JpaRepository<ProductStatistics, Integer> {
    @Query("SELECT SUM(p.wastedQuantity), SUM(p.eatenQuantity), p.product.name FROM ProductStatistics p GROUP BY p.product.id")
    List<ProductStatisticsDto> findByGroupedByProduct();
}
