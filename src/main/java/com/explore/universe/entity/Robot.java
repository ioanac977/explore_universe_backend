package com.explore.universe.entity;

import javax.persistence.*;

@Entity
@Table(name = "robot")
public class Robot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String code;
    @ManyToOne
    @JoinColumn(name = "team", nullable = true)
    private Team team;

    public int getId() {
        return id;
    }

    public String getCode() {
        return code;
    }
}
