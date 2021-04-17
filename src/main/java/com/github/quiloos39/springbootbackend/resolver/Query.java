package com.github.quiloos39.springbootbackend.resolver;

import com.github.quiloos39.springbootbackend.pojo.Player;
import com.github.quiloos39.springbootbackend.service.PlayerService;
import graphql.kickstart.tools.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Query implements GraphQLQueryResolver {

    @Autowired
    private PlayerService playerService;

    public List<Player> allPlayers() {
        return playerService.findAll();
    }

    public Player player(Long id) {
        return playerService.find(id);
    }
}
