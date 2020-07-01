package com.leticia.ecommerce.model;

import com.leticia.ecommerce.dto.ClientDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.mindrot.jbcrypt.BCrypt;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Entidade de Cliente
 *
 * @author Leticia Corral
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String password;

    public Client(ClientDTO client) {

        this.id = client.getId();
        this.name = client.getName();
        this.email = client.getEmail().toLowerCase();
        this.password = getPassword(client.getPassword());
    }

    public void setEmail(String email) {
        this.email = email.toLowerCase();
    }

    public String getEmail(String email) {
        return email.toLowerCase();
    }

    public void setPassword(String password) {
        this.password = BCrypt.hashpw(password, BCrypt.gensalt());
    }

    public String getPassword(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }
}
