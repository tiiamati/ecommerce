package com.leticia.ecommerce.repository;

import com.leticia.ecommerce.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Interface de produto
 *
 * @author Leticia Corral
 */

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
}
