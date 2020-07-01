package com.leticia.ecommerce.controller;

import com.leticia.ecommerce.model.Cart;
import com.leticia.ecommerce.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/ecommerce/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @GetMapping
    public List<Cart> list() {
        return cartService.getAll();
    }

    @GetMapping(path = "/{id}")
    public Cart get(@PathVariable("id") int id) {
        return cartService.get(id);
    }

    @PostMapping
    public Cart insert(@RequestBody Cart cart) {
        return cartService.insert(cart);
    }
}
