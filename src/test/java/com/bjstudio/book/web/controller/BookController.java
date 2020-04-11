package com.bjstudio.book.web.controller;

import java.util.List;
import java.util.Map;

import com.bjstudio.book.persistence.domain.Book;
import com.bjstudio.book.service.BookService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;



/**
 * BookController
 */
@RequiredArgsConstructor
@RequestMapping(BookController.BASE_URL)
@RestController
public class BookController {

    public static final String BASE_URL = "/books";

    private final BookService bookService;

    @GetMapping
    public List<Book> finaAllBooks() {
        return bookService.findAllBooks();
    }

    @GetMapping("/{bookId}")
    public Book findBook(@PathVariable Long bookId) {
        return bookService.findBookById(bookId);
    }

    @PostMapping()
    public Book createBook(@RequestBody Book book) {
        return bookService.createBook(book);
    }
    
    @DeleteMapping("/{bookId}")
    public void deleteBook(@PathVariable Long bookId) {
        bookService.deleteBook(bookId);
    }

    @PutMapping(value="/{bookId}")
    public Book updateBook(@PathVariable Long bookId, @RequestBody Book book) {
        return bookService.updateBook(book, bookId);
    }

    @PatchMapping("/{bookId}")
    public Book updateBook(@PathVariable Long bookId, @RequestBody Map<String, String> updates) {
        return bookService.updateBook(updates, bookId);
    }
}