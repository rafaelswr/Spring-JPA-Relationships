package dev.jpa.Controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("")
public class AppController {

    @GetMapping("/")
    public ResponseEntity<String> greetings(){
        return new ResponseEntity<>("Ola", HttpStatus.OK);
    }

}
