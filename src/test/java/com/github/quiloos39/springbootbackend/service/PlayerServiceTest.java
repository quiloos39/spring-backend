package com.github.quiloos39.springbootbackend.service;

import com.github.quiloos39.springbootbackend.pojo.Player;
import com.github.quiloos39.springbootbackend.pojo.Position;
import com.github.quiloos39.springbootbackend.repository.PlayerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class PlayerServiceTest {

    @Autowired
    private PlayerService playerService;

    @Autowired
    private PlayerRepository playerRepository;

    @Test
    void findAll() {
        Player player1 = new Player();
        player1.setName("Necdet");
        player1.setSurname("Efe");
        player1.setPosition(Position.SG);
        playerRepository.save(player1);

        Player player2 = new Player();
        player2.setName("Mehmet");
        player2.setSurname("Kaya");
        player2.setPosition(Position.C);
        playerRepository.save(player2);

        List<Player> expected = new ArrayList<>();
        expected.add(player1);
        expected.add(player2);

        List<Player> players = playerService.findAll();
        assertEquals(players, expected);
    }

    @Test
    void findPlayer() {

    }

    @Test
    void addPlayer() {

    }

    @Test
    void removePlayer() {

    }
}