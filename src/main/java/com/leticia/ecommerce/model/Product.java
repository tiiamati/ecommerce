package com.leticia.ecommerce.model;

import com.leticia.ecommerce.dto.ProductDTO;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

/**
 * Entidade de produto
 *
 * @author Leticia Corral
 */
@Entity
@Data
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String image;
    private String description;
    private BigDecimal value;
    private int stock;

    @OneToMany(mappedBy = "product")
    private Set<CartProducts> carts = new HashSet<>();

    public Product(ProductDTO product) {
        this.name = product.getName();
        this.image = product.getImage();
        this.description = product.getDescription();
        this.value = product.getValue();
        this.stock = product.getStock();
    }

    public Product(String name, String image, String description, BigDecimal value, int stock) {
        this.name = name;
        this.image = image;
        this.description = description;
        this.value = value;
        this.stock = stock;
    }
}
