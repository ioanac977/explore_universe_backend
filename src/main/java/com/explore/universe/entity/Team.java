package com.explore.universe.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "team")
public class Team implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @OneToOne(fetch = FetchType.LAZY,
            cascade = CascadeType.ALL,
            mappedBy = "team")
    private HumanCaptain humanCaptain;
    @Column
    @OneToMany(mappedBy = "team",
            cascade = CascadeType.REMOVE)
    private List<Robot> robots = new ArrayList<Robot>();

    @OneToOne(fetch = FetchType.LAZY,
            cascade = CascadeType.ALL,
            mappedBy = "team")
    private Planet planet;

    public int getId() {
        return id;
    }

    public HumanCaptain getHumanCaptain() {
        return humanCaptain;
    }

    public List<Robot> getRobots() {
        return robots;
    }
}
