package youtube.java.puzzle.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import youtube.java.puzzle.model.Client;
import youtube.java.puzzle.service.ClientService;

import java.util.List;

@RestController
@RequestMapping(value = "/client")
public class ClientController {

    @Autowired
    ClientService clientService;

    @GetMapping("/")
    public ResponseEntity<List<Client>> getAllClients(){
        return new ResponseEntity<>( clientService.getAllClient(), HttpStatus.OK );
    }
}
