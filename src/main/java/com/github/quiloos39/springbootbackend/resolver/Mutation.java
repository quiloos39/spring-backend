package com.github.quiloos39.springbootbackend.resolver;

import com.github.quiloos39.springbootbackend.pojo.Player;
import com.github.quiloos39.springbootbackend.pojo.Position;
import com.github.quiloos39.springbootbackend.service.PlayerService;
import graphql.kickstart.tools.GraphQLMutationResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Mutation implements GraphQLMutationResolver {

    @Autowired
    private PlayerService playerService;

    public Player addPlayer(String name, String surname, Position position) {
        if (playerService.findAll().size() < 12) {
            return playerService.addPlayer(name, surname, position);
        }
        return null;
    }

    public String removePlayer(Long id) {
        return playerService.removePlayer(id);
    }
}
