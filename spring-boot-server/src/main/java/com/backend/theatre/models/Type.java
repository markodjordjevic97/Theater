package com.backend.theatre.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "types")
public class Type implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Type required!")
    @Size(max = 40)
    private String type;

    @OneToMany(mappedBy = "type")
    @JsonIgnore
    private Set<Performance> performances;


    public Type() {
    }

    public Type(Long id, Set<Performance>performances, @NotBlank(message = "Type required!") @Size(max = 40) String type) {
        this.id = id;
        this.type = type;
        this.performances = performances;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<Performance> getPerformances() {
        return performances;
    }

    public void setPerformances(Set<Performance> performances) {
        this.performances = performances;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
