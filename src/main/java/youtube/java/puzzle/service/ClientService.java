package youtube.java.puzzle.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import youtube.java.puzzle.model.Client;
import youtube.java.puzzle.repository.ClientRepository;

import java.util.List;

@Service
public class ClientService {
    @Autowired
    ClientRepository clientRepository;

    public List<Client> getAllClient(){
        return clientRepository.findAll();
    }
}
