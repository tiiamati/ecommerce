package com.leticia.ecommerce.controller;

import com.leticia.ecommerce.config.StringFile;
import com.leticia.ecommerce.service.ClientService;
import com.leticia.ecommerce.service.ProductService;
import com.leticia.ecommerce.dto.ClientDTO;
import com.leticia.ecommerce.dto.ProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@CrossOrigin("*")
@RequestMapping("/ecommerce/insertData")
public class DataController {

    @Autowired
    private ClientService clientService;

    @Autowired
    private ProductService productService;

    @GetMapping
    public void setData() {

        if (clientService.getAll().isEmpty()){
            setClient();
        }

        if (productService.getAll().isEmpty()){
            setProducts();
        }
    }

    public String setClient() {
        return clientService.insert(ClientDTO.builder()
                .name("Leticia")
                .email("le.martincorral@gmail.com")
                .password("123")
                .build());
    }

    public String setProducts() {
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


        return StringFile.DB_SAVE;
    }
}
