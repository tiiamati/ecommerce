package com.leticia.ecommerce.controller;

import com.leticia.ecommerce.dto.ClientDTO;
import com.leticia.ecommerce.model.Client;
import com.leticia.ecommerce.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/ecommerce/clients")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping
    public List<Client> getClient() {
        return clientService.getAll();
    }

    @GetMapping(path = "/{id}")
    public Client getClient(@PathVariable("id") Long id) {
        return clientService.get(id);
    }

    @PostMapping
    public String insertClient(@RequestBody ClientDTO client) {
        return clientService.insert(client);
    }

    @PostMapping(path = "/login")
    public Boolean validateLogin(@RequestBody ClientDTO client) {
        return clientService.validateLogin(client);
    }
}


