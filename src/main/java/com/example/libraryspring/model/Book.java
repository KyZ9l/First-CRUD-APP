package com.example.libraryspring.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;


@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "book")
public class Book {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;

    @NotBlank(message = "Book title must not be empty")
    @Size(min = 2, max = 50, message = "Book title must be between 2 and 50 characters")
    @Column(name = "title")
    private String title;


    @NotBlank(message = "Name of author must not be empty")
    @Size(min = 2, max = 50, message = "Name of author must be between 2 and 50 characters")
    @Column(name ="author")
    private String author;

    @Min(value = 1500, message = "The book can hardly be less than 1500")
    @Column(name = "year")
    private int year;

    @ManyToOne
    @JoinColumn(name ="person_id", referencedColumnName = "id")
    private Person owner;

    @Column(name = "taken_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date takenAt;

    @Transient
    private boolean expired;


    public Book(String title, String author, int year) {
        this.title = title;
        this.author = author;
        this.year = year;
    }


}
