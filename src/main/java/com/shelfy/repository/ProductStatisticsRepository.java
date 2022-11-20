package com.shelfy.repository;

import com.shelfy.model.ProductStatistics;
import com.shelfy.model.dto.ProductStatisticsDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductStatisticsRepository extends JpaRepository<ProductStatistics, Integer> {
    @Query("SELECT " +
            "new com.shelfy.model.dto.ProductStatisticsDto(SUM(ps.wastedQuantity), SUM(ps.eatenQuantity), p.name) " +
            "FROM ProductStatistics ps " +
            "JOIN Product p " +
            "ON ps.product.id = p.id " +
            "GROUP BY ps.product.id")
    List<ProductStatisticsDto> getProductStatistics();
}
