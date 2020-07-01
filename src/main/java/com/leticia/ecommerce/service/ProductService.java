package com.leticia.ecommerce.service;

import com.leticia.ecommerce.config.StringFile;
import com.leticia.ecommerce.dto.ProductDTO;
import com.leticia.ecommerce.model.Product;
import com.leticia.ecommerce.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service referente produtos
 *
 * @author Leticia Corral
 */

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    /**
     * Retornar todos os produtos cadastrados
     *
     * @return todos os produtos cadastrados na base
     */
    public List<Product> getAll() {
        try {
            return productRepository.findAll();
        } catch (Exception ex) {
            throw ex;
        }
    }

    /**
     * Retorna um produto
     *
     * @param id identificador do produto
     * @return apenas o produto passado como parametro
     */
    public Product get(int id) {
        try {
            return productRepository.findById(id).get();
        } catch (Exception ex) {
            throw ex;
        }
    }

    /**
     * Insere um produto
     *
     * @param product entidade produto
     * @return mensagem de sucesso ao incluir o produto
     */
    public String insert(ProductDTO product) {
        try {

            Product p = new Product(product);
            productRepository.save(p);

            return StringFile.DB_SAVE;
        } catch (Exception ex) {
            throw ex;
        }
    }
}
