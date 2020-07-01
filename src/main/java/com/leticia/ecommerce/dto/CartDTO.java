package com.leticia.ecommerce.dto;

import com.leticia.ecommerce.model.CartProducts;
import com.leticia.ecommerce.model.Client;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

/**
 * Carrinho de compras
 *
 * @author Leticia Corral
 */
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CartDTO {

    private Long id;
    private Client client;
    private BigDecimal value;
    private List<CartProducts> products;
}
