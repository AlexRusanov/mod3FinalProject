package eparliament.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by alexandrrusanov on 31/8/17.
 */
@Entity
@Table(name = "voting")
public class Voting {

    @Id
    @Access(AccessType.PROPERTY)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bill_id")
    private Bill bill;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "deputy_id")
    private Deputy deputy;

    @NotNull(message = "Обязательное поле")
    @Enumerated(EnumType.ORDINAL)
    private Vote vote;

    public Voting() {
    }

    public Voting(Bill bill) {
        this.bill = bill;
    }

    public Voting(Deputy deputy) {
        this.deputy = deputy;
    }

    public Voting(Bill bill, Deputy deputy, Vote vote) {
        this.bill = bill;
        this.deputy = deputy;
        this.vote = vote;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Voting voting = (Voting) o;

        if (bill != null ? !bill.equals(voting.bill) : voting.bill != null) return false;
        if (deputy != null ? !deputy.equals(voting.deputy) : voting.deputy != null) return false;
        return vote == voting.vote;
    }

    @Override
    public int hashCode() {
        int result = bill != null ? bill.hashCode() : 0;
        result = 31 * result + (deputy != null ? deputy.hashCode() : 0);
        result = 31 * result + (vote != null ? vote.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Voting{" +
                "id=" + id +
                ", bill=" + bill +
                ", deputy=" + deputy +
                ", vote=" + vote +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Bill getBill() {
        return bill;
    }

    public void setBill(Bill bill) {
        this.bill = bill;
    }

    public Deputy getDeputy() {
        return deputy;
    }

    public void setDeputy(Deputy deputy) {
        this.deputy = deputy;
    }

    public Vote getVote() {
        return vote;
    }

    public void setVote(Vote vote) {
        this.vote = vote;
    }
}
