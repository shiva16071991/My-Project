package com.example.demo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long>{

    public Book findByBookName(String bookName);

    public List<Book> findByCategory(String category);

}
