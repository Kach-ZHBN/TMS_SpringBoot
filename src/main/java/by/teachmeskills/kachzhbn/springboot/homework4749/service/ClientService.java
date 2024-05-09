package by.teachmeskills.kachzhbn.springboot.homework4749.service;

import by.teachmeskills.kachzhbn.springboot.homework4749.model.Client;
import by.teachmeskills.kachzhbn.springboot.homework4749.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService {
    private final ClientRepository clientRepository;

    @Autowired
    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public Client getClientByName(String name){
        return clientRepository.findClientByName(name);
    }
}
