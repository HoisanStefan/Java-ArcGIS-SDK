package net.javaguides.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.javaguides.springboot.exception.ResourceNotFoundException;
import net.javaguides.springboot.model.Client;
import net.javaguides.springboot.repository.ClientRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
public class ClientController {

    @Autowired
    private ClientRepository clientRepository;

    // get all employees
    @GetMapping("/clients")
    public List<Client> getAllClients(){
        return clientRepository.findAll();
    }

    // create employee rest api
    @PostMapping("/clients")
    public Client createClient(@RequestBody Client client) {
        return clientRepository.save(client);
    }

    // get employee by id rest api
    @GetMapping("/clients/{id}")
    public ResponseEntity<Client> getClientById(@PathVariable Long id) {
        Client client = clientRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Client not exist with id :" + id));
        return ResponseEntity.ok(client);
    }


    // update employee rest api
    @PutMapping("/clients/{id}")
    public ResponseEntity<Client> updateClient(@PathVariable Long id, @RequestBody Client clientDetails){
        Client client = clientRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Client not exist with id :" + id));

        client.setEmail(clientDetails.getEmail());
        client.setParola(clientDetails.getParola());
        client.setTelefon(clientDetails.getTelefon());

        Client updatedClient = clientRepository.save(client);
        return ResponseEntity.ok(updatedClient);
    }

    // delete employee rest api
    @DeleteMapping("/clients/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteClient(@PathVariable Long id){
        Client client = clientRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Client not exist with id :" + id));

        clientRepository.delete(client);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }


}