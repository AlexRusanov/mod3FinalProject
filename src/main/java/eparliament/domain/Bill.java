package eparliament.domain;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * Created by alexandrrusanov on 29/8/17.
 */
//@Entity
//@Table(name = "bills")
public class Bill {

//    @Id
//    @Access(AccessType.PROPERTY)
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Integer id;
//
//    @NotBlank(message = "Обязательное поле")
//    private String title;
//
//    @NotBlank(message = "Обязательное поле")
//    private String author;
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "deputy_id")
//    private Deputy deputy;
//
//    private LocalDateTime submissionDate;
//
//    @NotBlank(message = "Обязательное поле")
//    private String text;
}
