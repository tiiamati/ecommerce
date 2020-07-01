package com.leticia.ecommerce.service;

import com.leticia.ecommerce.config.StringFile;
import com.leticia.ecommerce.model.Cart;
import com.leticia.ecommerce.model.CartProducts;
import com.leticia.ecommerce.model.Product;
import com.leticia.ecommerce.repository.CartRepository;
import com.leticia.ecommerce.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

/**
 * Service referente carrinho de compra
 *
 * @author Leticia Corral
 */

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private ProductRepository productRepository;

    /**
     * Retornar todos os carrinhos de compra cadastrados
     *
     * @return todos os carrinhos de compra cadastrados na base
     */
    public List<Cart> getAll() {
        try {
            return cartRepository.findAll();
        } catch (Exception ex) {
            throw ex;
        }
    }

    /**
     * Retornar um determinado carrinho de compras
     *
     * @param id identificador do carrinho de compra
     * @return apenas o carrinho de compra passado como parametro
     */
    public Cart get(int id) {
        try {
            return cartRepository.findById(id).get();
        } catch (Exception ex) {
            throw ex;
        }
    }

    /**
     * Insere um carrinho de compra
     *
     * @param cart entidade carrinho de compra
     * @return mensagem de sucesso ao incluir o carrinho de compra
     */
    public Cart insert(Cart cart) {
        try {
            boolean valid = true;

            for (CartProducts cartProducts: cart.getProducts()) {
                if (!hasStock(cartProducts)){
                    valid = false;
                    break;
                }
            }

            if (valid){
                cart.setValue(cart.getProducts().stream()
                        .map(p -> {
                                    updateStock(p);
                                    return p.getProduct().getValue()
                                            .multiply(BigDecimal.valueOf(p.getQuantity()));
                                    })
                        .reduce(BigDecimal.ZERO, BigDecimal::add));

                return cartRepository.save(cart);
            } else {
                return cart;
            }
        } catch (Exception ex) {
            throw ex;
        }
    }

    /**
     * Valida o estoque do produto
     *
     * @param cartProducts entidade relacional de carrinho de compra com produtos
     * @return boolean indicando true para quando existe estoque do produto, false para quando não existe estoque para o produto
     */
    private Boolean hasStock(CartProducts cartProducts) {
        return productRepository.findById(cartProducts.getProduct().getId()).get().getStock() >= cartProducts.getQuantity();
    }

    /**
     * Atualiza estoque do produto
     *
     * @param cartProducts entidade relacional de carrinho de compra com produtos
     * @return mensagem de sucesso ao autualizar o estoque do produto
     */
    public String updateStock(CartProducts cartProducts) {
        try {

            Product productUpdate = productRepository.findById(cartProducts.getProduct().getId()).get();
            productUpdate.setStock(productUpdate.getStock() - cartProducts.getQuantity());
            productRepository.save(productUpdate);

            return StringFile.DB_UPDATE;
        } catch (Exception ex) {
            throw ex;
        }
    }
}
