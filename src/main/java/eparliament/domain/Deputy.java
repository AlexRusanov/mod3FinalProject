package eparliament.domain;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

/**
 * Created by alexandrrusanov on 25/8/17.
 */
@Entity
@Table(name = "deputies")
public class Deputy {

    @Id
    @Access(AccessType.PROPERTY)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "Обязательное поле")
    private String name;

    @NotBlank(message = "Обязательное поле")
    private String surname;

    @NotNull(message = "Обязательное поле")
    @Enumerated(EnumType.ORDINAL)
    private Gender gender;

    @NotBlank(message = "Обязательное поле")
    private LocalDateTime birthday;

    @NotBlank(message = "Обязательное поле")
    private String fraction;

    public Deputy() {
    }

    public Deputy(String name, String surname, Gender gender, LocalDateTime birthday, String fraction) {
        this.name = name;
        this.surname = surname;
        this.gender = gender;
        this.birthday = birthday;
        this.fraction = fraction;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Deputy deputy = (Deputy) o;

        if (id != null ? !id.equals(deputy.id) : deputy.id != null) return false;
        if (name != null ? !name.equals(deputy.name) : deputy.name != null) return false;
        if (surname != null ? !surname.equals(deputy.surname) : deputy.surname != null) return false;
        if (gender != deputy.gender) return false;
        if (birthday != null ? !birthday.equals(deputy.birthday) : deputy.birthday != null) return false;
        return fraction != null ? fraction.equals(deputy.fraction) : deputy.fraction == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        result = 31 * result + (gender != null ? gender.hashCode() : 0);
        result = 31 * result + (birthday != null ? birthday.hashCode() : 0);
        result = 31 * result + (fraction != null ? fraction.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Deputy{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", gender=" + gender +
                ", birthday=" + birthday +
                ", fraction='" + fraction + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public LocalDateTime getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDateTime birthday) {
        this.birthday = birthday;
    }

    public String getFraction() {
        return fraction;
    }

    public void setFraction(String fraction) {
        this.fraction = fraction;
    }

    public String printInfo(){return String.format("%s %s, фракция - %s", name, surname, fraction);}
}
