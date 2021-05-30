package com.backend.theatre.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "performances")
public class Performance implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Title required!")
    @Size(max = 40)
    private String title;

    @NotBlank(message = "Duration required!")
    private String duration;

    @Size(max = 1000)
    private String description;

    @ManyToOne
    @JoinColumn(name = "writer_id", nullable = false)
    private Writer writer;

    @Size(max = 20)
    private String writerSurname;

    @ManyToOne
    @JoinColumn(name = "type_id", referencedColumnName = "id", nullable = false)
    private Type type;

    @OneToMany(mappedBy = "performance")
    @JsonIgnore
    private Set<Repertoire> repertoires;


    public Performance() {
    }

    public Performance(Long id, @NotBlank(message = "Title required!") @Size(max = 40) String title, @NotBlank(message = "Duration required!") String duration, @Size(max = 1000) String description, Writer writer, @Size(max = 20) String writerSurname, Type type, Set<Repertoire> repertoires) {
        this.id = id;
        this.title = title;
        this.duration = duration;
        this.description = description;
        this.writer = writer;
        this.writerSurname = writerSurname;
        this.type = type;
        this.repertoires = repertoires;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Writer getWriter() {
        return writer;
    }

    public void setWriter(Writer writer) {
        this.writer = writer;
    }

    public Set<Repertoire> getRepertoires() {
        return repertoires;
    }

    public void setRepertoires(Set<Repertoire> repertoires) {
        this.repertoires = repertoires;
    }

    public String getWriterSurname() {
        return writerSurname;
    }

    public void setWriterSurname(String writerSurname) {
        this.writerSurname = writerSurname;
    }
}
