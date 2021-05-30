package com.backend.theatre.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "repertoires")
public class Repertoire implements Serializable {
    @EmbeddedId
    private RepertoirePK repertoirePK;

    @ManyToOne
    @JoinColumn(name = "performance_id", referencedColumnName = "id", nullable = false)
    private Performance performance;

    @Size(max = 40)
    private String performanceTitle;

    @OneToMany(mappedBy = "repertoire")
    @JsonIgnore
    private Set<Ticket> tickets;


    public Repertoire() {
    }

    public Repertoire(RepertoirePK repertoirePK, Performance performance, @Size(max = 40) String performanceTitle, Set<Ticket> tickets) {
        this.repertoirePK = repertoirePK;
        this.performance = performance;
        this.performanceTitle = performanceTitle;
        this.tickets = tickets;
    }

    public RepertoirePK getRepertoirePK() {
        return repertoirePK;
    }

    public void setRepertoirePK(RepertoirePK repertoirePK) {
        this.repertoirePK = repertoirePK;
    }

    public Performance getPerformance() {
        return performance;
    }

    public void setPerformance(Performance performance) {
        this.performance = performance;
    }

    public Set<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(Set<Ticket> tickets) {
        this.tickets = tickets;
    }
}
