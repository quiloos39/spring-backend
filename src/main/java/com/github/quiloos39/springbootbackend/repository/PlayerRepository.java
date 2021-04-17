package com.github.quiloos39.springbootbackend.repository;

import com.github.quiloos39.springbootbackend.pojo.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<Player, Long> {
}
