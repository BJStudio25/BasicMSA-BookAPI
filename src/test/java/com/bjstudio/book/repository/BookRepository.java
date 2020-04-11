package com.bjstudio.book.repository;

import com.bjstudio.book.persistence.domain.Book;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * BookRepository
 */
public interface BookRepository extends JpaRepository<Book, Long> {

    
}