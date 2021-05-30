package com.backend.theatre.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Set;

@Entity
@Table(name = "writers")
public class Writer implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Writer name required!")
    @Size(max = 30)
    private String name;

    @NotBlank(message = "Writer surname required")
    @Size(max = 30)
    private String surname;

    @NotBlank(message = "Date of birth required!")
    private Timestamp birthDate;

    @OneToMany(mappedBy = "writer")
    @JsonIgnore
    private Set<Performance> performances;

    public Writer() {
    }

    public Writer(Long id, @NotBlank(message = "Writer name required!") @Size(max = 30) String name, @NotBlank(message = "Writer surname required") @Size(max = 30) String surname, @NotBlank(message = "Date of birth required!") Timestamp birthDate, Set<Performance> performances) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
        this.performances = performances;
    }

    public Timestamp getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Timestamp birthDate) {
        this.birthDate = birthDate;
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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Set<Performance> getPerformances() {
        return performances;
    }

    public void setPerformances(Set<Performance> performances) {
        this.performances = performances;
    }
}
