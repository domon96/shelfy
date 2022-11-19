/*
 * Copyright (C) Motorola Solutions, INC.
 * All Rights Reserved.
 */

package com.shelfy.repository;

import com.shelfy.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Integer, Product> {
}
