package com.leticia.ecommerce.dto;

import lombok.*;

import java.math.BigDecimal;

/**
 * Produc
 *
 * @author Leticia Corral
 */
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {

    private Long id;
    private String name;
    private String image;
    private String description;
    private BigDecimal value;
    private int stock;
}
