package com.backend.theatre.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "seats")
public class Seat implements Serializable {
    @EmbeddedId
    private SeatPK seatPK;

    @NotBlank(message = "Location is required!")
    @Size(max = 30)
    private String location;

    @ManyToOne
    @JoinColumn(name = "section_id", referencedColumnName = "id", nullable = false)
    private Section section;

    @OneToMany(mappedBy = "seat")
    @JsonIgnore
    private Set<Ticket> tickets;

    public Seat() {
    }

    public Seat(SeatPK seatPK, @NotBlank(message = "Location is required!") @Size(max = 30) String location, Section section, Set<Ticket> tickets) {
        this.seatPK = seatPK;
        this.location = location;
        this.section = section;
        this.tickets = tickets;
    }

    public SeatPK getSeatPK() {
        return seatPK;
    }

    public void setSeatPK(SeatPK seatPK) {
        this.seatPK = seatPK;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Section getSection() {
        return section;
    }

    public void setSection(Section section) {
        this.section = section;
    }

    public Set<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(Set<Ticket> tickets) {
        this.tickets = tickets;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Seat seat = (Seat) o;
        return Objects.equals(seatPK, seat.seatPK) &&
                Objects.equals(location, seat.location) &&
                Objects.equals(section, seat.section) &&
                Objects.equals(tickets, seat.tickets);
    }

    @Override
    public int hashCode() {
        return Objects.hash(seatPK, location, section, tickets);
    }
}
