package com.github.quiloos39.springbootbackend.service;

import com.github.quiloos39.springbootbackend.pojo.Player;
import com.github.quiloos39.springbootbackend.pojo.Position;
import com.github.quiloos39.springbootbackend.repository.PlayerRepository;
import org.hibernate.jdbc.Expectation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerService {

    @Autowired
    private PlayerRepository playerRepository;

    public List<Player> findAll() {
        return playerRepository.findAll();
    }

   // Another bad query i need to fix this.
    public Player find(Long id) {
        for (Player player : playerRepository.findAll()) {
            if (player.getId().equals(id)) {
                return player;
            }
        }
        return null;
    }

    public Player addPlayer(String name, String surname, Position position) {
        Player player = new Player();
        player.setName(name);
        player.setSurname(surname);
        player.setPosition(position);
        return playerRepository.save(player);
    }

    // Still Inefficient i think because i have to query to find player
    // and then another query to remove it.
    public String removePlayer(Long id) {
        if  (playerRepository.findById(id).isPresent()) {
            playerRepository.deleteById(id);
            return "Removed.";
        }
        return "For given ID player doesn't exist.";
    }
}
