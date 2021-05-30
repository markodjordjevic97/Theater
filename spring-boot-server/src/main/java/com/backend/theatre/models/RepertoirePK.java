package com.backend.theatre.models;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;

@Embeddable
public class RepertoirePK implements Serializable {
    private Timestamp date_id;
    private Long performance;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RepertoirePK that = (RepertoirePK) o;
        return Objects.equals(date_id, that.date_id) &&
                Objects.equals(performance, that.performance);
    }

    @Override
    public int hashCode() {
        return Objects.hash(date_id, performance);
    }
}
