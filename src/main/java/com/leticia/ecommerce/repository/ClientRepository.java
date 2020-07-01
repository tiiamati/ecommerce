package com.leticia.ecommerce.repository;

import com.leticia.ecommerce.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Interface de cliente
 *
 * @author Leticia Corral
 */
@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

    Client findOneByEmail(String email);
}
