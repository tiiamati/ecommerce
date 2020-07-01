package com.leticia.ecommerce.repository;

import com.leticia.ecommerce.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Interface de carrinho de produto
 *
 * @author Leticia Corral
 */
@Repository
public interface CartRepository extends JpaRepository<Cart, Integer> {
}
