package by.teachmeskills.kachzhbn.springboot.homework4749.controller;

import by.teachmeskills.kachzhbn.springboot.homework4749.model.Client;
import by.teachmeskills.kachzhbn.springboot.homework4749.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/client")
public class ClientController {

    private final ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping("/{name}")
    public ResponseEntity<Client> getClient(@PathVariable String name){
        ResponseEntity<Client> responseEntity;
        Client clientByName = clientService.getClientByName(name);
        if(clientByName == null){
            responseEntity = ResponseEntity.notFound().build();
        }else {
            responseEntity = ResponseEntity.ok(clientByName);
        }
        return responseEntity;
    }
}
