package com.backend.theatre.models;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class SeatPK implements Serializable {
    private Long id;
    private Long queue;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SeatPK seatPK = (SeatPK) o;
        return Objects.equals(id, seatPK.id) &&
                Objects.equals(queue, seatPK.queue);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, queue);
    }
}
