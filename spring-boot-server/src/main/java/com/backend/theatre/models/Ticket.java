package com.backend.theatre.models;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "tickets")
public class Ticket implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(max = 20)
    private String payment;

    @NotBlank
    private int price;

    @ManyToOne
    @JoinColumn(name = "user_id",referencedColumnName = "id", nullable = false)
    private User user;

    @MapsId("id")
    @JoinColumns({
            @JoinColumn(name = "seat_id", referencedColumnName = "id"),
            @JoinColumn(name = "queue_id", referencedColumnName = "queue")
    })
    @ManyToOne
    private Seat seat;

    @MapsId("date_id")
    @JoinColumns({
            @JoinColumn(name = "date_id", referencedColumnName = "date_id"),
            @JoinColumn(name = "performance_id", referencedColumnName = "performance")
    })
    @ManyToOne
    private Repertoire repertoire;


    public Ticket() {
    }

    public Ticket(Long id, @NotBlank @Size(max = 20) String payment, @NotBlank int price, Seat seat, User user, Repertoire repertoire) {
        this.id = id;
        this.payment = payment;
        this.price = price;
        this.seat = seat;
        this.user = user;
        this.repertoire = repertoire;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Seat getSeat() {
        return seat;
    }

    public void setSeat(Seat seat) {
        this.seat = seat;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ticket ticket1 = (Ticket) o;
        return price == ticket1.price &&
                Objects.equals(id, ticket1.id) &&
                Objects.equals(payment, ticket1.payment) &&
                Objects.equals(seat, ticket1.seat) &&
                Objects.equals(user, ticket1.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, payment, price, seat, user);
    }


    public Repertoire getRepertoire() {
        return repertoire;
    }

    public void setRepertoire(Repertoire repertoire) {
        this.repertoire = repertoire;
    }
}
