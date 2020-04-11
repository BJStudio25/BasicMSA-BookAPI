package com.bjstudio.book.persistence.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Builder;
import lombok.Getter;

/**
 * Book
 */
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String author;

    @Builder
    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public void updateAuthor(String author) {
        this.author = author;
    }

    public void updateTitle(String title) {
        this.title = title;
    }
    
}