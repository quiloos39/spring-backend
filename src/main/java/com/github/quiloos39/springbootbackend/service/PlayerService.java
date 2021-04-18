package com.github.quiloos39.springbootbackend.service;

import com.github.quiloos39.springbootbackend.pojo.Player;
import com.github.quiloos39.springbootbackend.pojo.Position;
import com.github.quiloos39.springbootbackend.repository.PlayerRepository;
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

    public Player findPlayer(int id) {
        return playerRepository.findById(id).orElse(null);
    }

    public Player addPlayer(String name, String surname, Position position) {
        if (playerRepository.count() < 12) {
            Player player = new Player();
            player.setName(name);
            player.setSurname(surname);
            player.setPosition(position);
            return playerRepository.save(player);
        }
        return null;
    }

    // Still Inefficient, i think because i am using 2 queries
    // First one to check if player exist Second one is to remove it
    // I would probably could just have used second one and check if it returned
    // but couldn't made it work.
    public String removePlayer(int id) {
        if (playerRepository.findById(id).isPresent()) {
            playerRepository.deleteById(id);
            return "Removed.";
        }
        return "Player doesn't exist.";
    }
}
