package com.example.libraryspring.repositories;

import com.example.libraryspring.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepositories extends JpaRepository<Book, Integer> {
    List<Book> findByTitleStartingWith(String title);
}
