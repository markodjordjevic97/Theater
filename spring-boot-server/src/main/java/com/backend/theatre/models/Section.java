package com.backend.theatre.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "sections")
public class Section implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Section name required!")
    @Size(max = 20)
    private String name;

    @OneToMany(mappedBy = "section")
    @JsonIgnore
    private Set<Seat> seats;

    public Section() {
    }

    public Section(Long id, @NotBlank(message = "Section name required!") @Size(max = 20) String name, Set<Seat> seats) {
        this.id = id;
        this.name = name;
        this.seats = seats;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Seat> getSeats() {
        return seats;
    }

    public void setSeats(Set<Seat> seats) {
        this.seats = seats;
    }
}
