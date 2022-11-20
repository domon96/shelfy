package com.shelfy.repository;

import com.shelfy.model.ProductStatistics;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductStatisticsRepository extends JpaRepository<ProductStatistics, Integer> {

}
