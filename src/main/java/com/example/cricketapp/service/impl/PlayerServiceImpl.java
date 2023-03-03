package com.example.cricketapp.service.impl;

import com.example.cricketapp.dao.PlayerRepo;
import com.example.cricketapp.model.Player;
import com.example.cricketapp.model.Team;
import com.example.cricketapp.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerServiceImpl implements PlayerService {
    @Autowired
    PlayerRepo repo;
    public ResponseEntity<List<Player>> addPlayers(){
        String [] t={"A","B"};
        for(int j=0;j<2;j++){
            int pid=getPlayers().size();
            String type="";
            for(int i=0;i<5;i++){
                if(i<3)type="batsman";
                else type="bowler";
                String name=t[j]+Integer.toString(i);
                Player p=new Player(pid,name,t[j],type);
                savePlayer(p);
                pid++;
            }
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(getPlayers());
    }

    @Override
    public List<Player> getPlayers() {
        return repo.findAll();
    }
    @Override
    public void savePlayer(Player player){
        repo.save(player);
    }

    @Override
    public List<Player> findByType(String type,String team) {
        return repo.findByType(type,team);
    }

    @Override
    public List<Player> findByTeam(String team) {
        return repo.findByTeam(team);
    }
}
