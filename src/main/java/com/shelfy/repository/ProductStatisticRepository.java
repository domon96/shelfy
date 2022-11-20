package com.shelfy.repository;

import com.shelfy.model.ProductStatistic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductStatisticRepository extends JpaRepository<ProductStatistic, Integer> {
    
}
