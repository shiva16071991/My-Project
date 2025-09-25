package com.example.demo.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class Book {

    @Id
    @Column(name="book_id")
    @GeneratedValue
    private Long id;

    @Column(name ="book_name")
    private String bookName;

    @Column
    private String Catagory;

    @Column(name="author")
    private String author;

    @Column
    private String publisher;


    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBookName() {
        return this.bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getCatagory() {
        return this.Catagory;
    }

    public void setCatagory(String Catagory) {
        this.Catagory = Catagory;
    }

    public String getAuthorName() {
        return this.author;
    }

    public void setAuthorName(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return this.publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }


}
