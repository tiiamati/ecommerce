package com.leticia.ecommerce.dto;

import lombok.*;

/**
 * Client
 *
 * @author Leticia Corral
 */
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ClientDTO {

    private Long id;
    private String name;
    private String email;
    private String password;

    public String getEmail(String email) {
        return email.toLowerCase();
    }

}
