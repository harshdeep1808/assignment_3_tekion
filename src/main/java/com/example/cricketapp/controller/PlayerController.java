package com.example.cricketapp.controller;

import com.example.cricketapp.model.Player;
import com.example.cricketapp.service.impl.PlayerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;

import java.util.List;

@RequestMapping("/player")
@RestController
public class PlayerController {

    @Autowired
    PlayerServiceImpl psi;
    @GetMapping(path="/addPlayers")
    public ResponseEntity<List<Player>> addPlayers(){
      return psi.addPlayers();
    }
}
