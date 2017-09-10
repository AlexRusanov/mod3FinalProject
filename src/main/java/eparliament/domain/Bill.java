package eparliament.domain;

import org.hibernate.annotations.*;
import org.hibernate.annotations.CascadeType;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;

/**
 * Created by alexandrrusanov on 29/8/17.
 */
@Entity
@Table(name = "bills")
public class Bill {

    @Id
    @Access(AccessType.PROPERTY)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "Обязательное поле")
    private String title;

    @NotBlank(message = "Обязательное поле")
    private String author;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;

    private LocalDateTime submission_date;

    @NotBlank(message = "Обязательное поле")
    private String text;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "session_id")
    private Session session;

    public Bill() {
    }

    public Bill(String title, String author, User user, LocalDateTime submission_date, String text, Session session) {
        this.title = title;
        this.author = author;
        this.user = user;
        this.submission_date = submission_date;
        this.text = text;
        this.session = session;
    }

    public Bill(User user) {
        this.user = user;
    }

    public Bill(Session session) {
        this.session = session;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Bill bill = (Bill) o;

        if (title != null ? !title.equals(bill.title) : bill.title != null) return false;
        if (author != null ? !author.equals(bill.author) : bill.author != null) return false;
        if (submission_date != null ? !submission_date.equals(bill.submission_date) : bill.submission_date != null)
            return false;
        if (text != null ? !text.equals(bill.text) : bill.text != null) return false;
        return session != null ? session.equals(bill.session) : bill.session == null;
    }

    @Override
    public int hashCode() {
        int result = title != null ? title.hashCode() : 0;
        result = 31 * result + (author != null ? author.hashCode() : 0);
        result = 31 * result + (submission_date != null ? submission_date.hashCode() : 0);
        result = 31 * result + (text != null ? text.hashCode() : 0);
        result = 31 * result + (session != null ? session.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Bill{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", submission_date=" + submission_date +
                ", text='" + text + '\'' +
                ", session=" + session +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalDateTime getSubmissionDate() {
        return submission_date;
    }

    public void setSubmissionDate(LocalDateTime submission_date) {
        this.submission_date = submission_date;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }
}
