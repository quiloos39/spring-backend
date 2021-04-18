package com.github.quiloos39.springbootbackend.pojo;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false)
    int id;
    @Column(name = "name", nullable = false)
    String name;
    @Column(name = "surname", nullable = false)
    String surname;
    @Column(name = "position", nullable = false)
    @Enumerated(EnumType.STRING)
    Position position;
}
