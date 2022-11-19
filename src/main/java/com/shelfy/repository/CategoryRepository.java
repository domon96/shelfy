/*
 * Copyright (C) Motorola Solutions, INC.
 * All Rights Reserved.
 */

package com.shelfy.repository;

import com.shelfy.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
