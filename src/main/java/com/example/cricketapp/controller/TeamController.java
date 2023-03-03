package com.example.cricketapp.controller;

import com.example.cricketapp.dao.TeamRepo;
import com.example.cricketapp.model.Team;
import com.example.cricketapp.service.impl.TeamServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/team")
@RestController
public class TeamController {

    @Autowired
    TeamServiceImpl tsi;

    @PostMapping(path="/addTeams",consumes= {"application/json"})
    public ResponseEntity<List<Team>> addTeams(@RequestBody List<Team> teams){
        return tsi.addTeams(teams);
    }
}
