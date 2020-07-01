package com.leticia.ecommerce.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

/**
 * Entidade relacional de carrinho de compras com produto
 *
 * @author Leticia Corral
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
public class CartProducts implements Serializable {

    @JsonIgnore
    @Id
    @ManyToOne
    @JoinColumn
    private Cart cart;

    @Id
    @ManyToOne
    @JoinColumn
    private Product product;

    private int quantity;

    public CartProducts(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }
}
