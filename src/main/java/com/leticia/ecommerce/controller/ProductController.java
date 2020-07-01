package com.leticia.ecommerce.controller;

import com.leticia.ecommerce.config.StringFile;
import com.leticia.ecommerce.dto.ClientDTO;
import com.leticia.ecommerce.dto.ProductDTO;
import com.leticia.ecommerce.model.Product;
import com.leticia.ecommerce.service.ClientService;
import com.leticia.ecommerce.service.ProductService;
import com.sun.rmi.rmid.ExecOptionPermission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/ecommerce/products")
public class ProductController {

    @Autowired
    private ClientService clientService;

    @Autowired
    private ProductService productService;

    @GetMapping
    public List<Product> getProducts() {

        List<Product> productList = productService.getAll();
        if (productList.isEmpty()) {
            productList = insertDatas();
        }
        return productList;
    }

    @GetMapping(path = "/{id}")
    public Product getProduct(@PathVariable("id") int id) {
        return productService.get(id);
    }

    @PostMapping
    public String insertProduct(@RequestBody ProductDTO product) {
        return productService.insert(product);
    }

    public List<Product> insertDatas() {

        try {
            if (clientService.getAll().isEmpty()){
                setClient();
            }
            return setProducts();
        } catch (Exception ex) {
            return null;
        }
    }

    public String setClient() {
        return clientService.insert(ClientDTO.builder()
                .name("Leticia")
                .email("ecommerce@maskara.com")
                .password("12345")
                .build());
    }

    public List<Product> setProducts() {
        productService.insert(ProductDTO.builder()
                .name("Máscara Rei Leão")
                .image("https://img.elo7.com.br/product/zoom/2FDB524/mascara-infantil-rei-leao-reutilizavel-mascara-infantil.jpg")
                .stock(4)
                .value(BigDecimal.valueOf(8.99))
                .description("Máscara Hakuna Matata, é lindo dizer.")
                .build());

        productService.insert(ProductDTO.builder()
                .name("Máscara Onomatopeia")
                .image("https://img.elo7.com.br/product/zoom/2FDEA25/mascara-infantil-super-herois-tecido-duplo-c-bolso-filtro-mascara-cirurgica-de-tecido.jpg")
                .stock(4)
                .value(BigDecimal.valueOf(8.99))
                .description("Máscara com palavras a que tentam reproduzir sons.")
                .build());

        productService.insert(ProductDTO.builder()
                .name("Máscara Frozen")
                .image("https://img.elo7.com.br/product/zoom/2F85981/mascara-infantil-tecido-duplo-bolso-p-filtro-ajuste-nasal-mascara-em-tecido-duplo-com-abertura-para-.jpg")
                .stock(4)
                .value(BigDecimal.valueOf(8.99))
                .description("Você quer brincar na neve, Let it go.")
                .build());

        productService.insert(ProductDTO.builder()
                .name("Máscara Bonequinhos")
                .image("https://img.elo7.com.br/product/zoom/2FDEC6B/mascara-infantil-super-herois-tecido-duplo-c-bolso-filtro-mascara-super-herois.jpg")
                .stock(4)
                .value(BigDecimal.valueOf(8.99))
                .description("Te protegendo do covide.")
                .build());

        productService.insert(ProductDTO.builder()
                .name("Máscara Disney")
                .image("https://img.elo7.com.br/product/zoom/2FE8874/mascara-infantil-desenho-animado-tecido-duplo-reutilizavel-mascara-infantil.jpg")
                .stock(4)
                .value(BigDecimal.valueOf(8.99))
                .description("Animações que fazem adulto chorar.")
                .build());

        productService.insert(ProductDTO.builder()
                .name("Máscara homem aranha")
                .image("https://img.elo7.com.br/product/zoom/2FDEA6C/mascara-infantil-homem-aranha-tecido-duplo-c-bolso-filtro-mascara-de-algodao.jpg")
                .stock(4)
                .value(BigDecimal.valueOf(8.99))
                .description("Com grandes poderes vem grandes responsabilidades.")
                .build());


        return productService.getAll();
    }
}
