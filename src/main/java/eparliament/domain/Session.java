package eparliament.domain;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * Created by alexandrrusanov on 29/8/17.
 */
@Entity
@Table(name = "sessions")
public class Session {

    @Id
    @Access(AccessType.PROPERTY)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String agenda;

    private LocalDateTime date;

    public Session() {
    }

    public Session(String agenda, LocalDateTime date) {
        this.agenda = agenda;
        this.date = date;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAgenda() {
        return agenda;
    }

    public void setAgenda(String agenda) {
        this.agenda = agenda;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }
}
