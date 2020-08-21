package com.explore.universe.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "planet")
public class Planet implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String name;
    @Lob
    @JsonIgnore
    private byte[] dataImage;
    @Column
    private String description;
    @Column(columnDefinition = "varchar(255) default 'TODO'")
    @Enumerated(EnumType.STRING)
    private Status status;

    @OneToOne(fetch = FetchType.LAZY, optional = true)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "team_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    Team team;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public byte[] getDataImage() {
        return dataImage;
    }


    public String getDescription() {
        return description;
    }

    public Status getStatus() {
        return status;
    }

    public Team getTeam() {
        return team;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDataImage(byte[] dataImage) {
        this.dataImage = dataImage;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}