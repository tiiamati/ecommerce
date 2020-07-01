package com.leticia.ecommerce.service;

import com.leticia.ecommerce.config.StringFile;
import com.leticia.ecommerce.dto.ClientDTO;
import com.leticia.ecommerce.model.Client;
import com.leticia.ecommerce.repository.ClientRepository;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * Service referente ao cliente
 *
 * @author Leticia Corral
 */

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private EntityManager entityManager;

    /**
     * Retornar todos os clientes cadastrados
     *
     * @return todos os clientes cadastrados na base
     */
    public List<Client> getAll() {
        try {
            return clientRepository.findAll();
        } catch (Exception ex) {
            throw ex;
        }
    }

    /**
     * Retorna um cliente
     *
     * @param id identificador do cliente
     * @return apenas o cliente passado como parametro
     */
    public Client get(Long id) {
        try {
            return clientRepository.findById(id).get();
        } catch (Exception ex) {
            throw ex;
        }
    }

    /**
     * Insere um cliente
     *
     * @param client entidade cliente
     * @return mensagem de sucesso ao incluir o cliente
     */
    public String insert(ClientDTO client) {
        try {

            Client c = new Client(client);
            clientRepository.save(c);
            return StringFile.DB_SAVE;
        } catch (Exception ex) {
            throw ex;
        }
    }

    /**
     * Valida o login de um cliente
     *
     * @param client entidade cliente
     * @return boolean indicando true quando o email e o password do cliente foram encontrados na base de dados, false quando não foram encontrados na base de dados
     */
    public Boolean validateLogin(ClientDTO client) {
        try {
            Client clientList = clientRepository.findOneByEmail(client.getEmail());
            return BCrypt.checkpw(client.getPassword(), clientList.getPassword());
        } catch (Exception ex) {
            throw ex;
        }
    }
}
