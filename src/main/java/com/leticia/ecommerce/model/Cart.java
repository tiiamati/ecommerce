package com.leticia.ecommerce.model;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Entidade de carrinho de compras
 *
 * @author Leticia Corral
 */
@Entity
@Data
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @OneToOne
    private Client client;
    private BigDecimal value;

    @OneToMany(mappedBy = "cart")
    private Set<CartProducts> products;

    public Cart(Client client, BigDecimal value, CartProducts... products) {
        this.client = client;
        this.value = value;
        for(CartProducts cartProduct : products) {
            cartProduct.setCart(this);
        }
        this.products = Stream.of(products).collect(Collectors.toSet());
    }
}
