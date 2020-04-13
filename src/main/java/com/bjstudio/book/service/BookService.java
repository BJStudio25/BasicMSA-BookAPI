package com.bjstudio.book.service;

import java.util.List;
import java.util.Map;

import com.bjstudio.book.persistence.domain.Book;
import com.bjstudio.book.repository.BookRepository;
import com.bjstudio.book.service.exception.BookNotFoundException;
import com.google.common.base.Preconditions;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;

/**
 * BookService
 */
@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class BookService {

    private final BookRepository bookRepository;

	public List<Book> findAllBooks() {
		return bookRepository.findAll();
	}

	public Book findBookById(Long bookId) {
		return bookRepository.findById(bookId).orElseThrow(() -> new BookNotFoundException("There is no book. Id: "+ bookId));
	}

    @Transactional(propagation = Propagation.REQUIRED)
	public Book createBook(Book book) {
		return bookRepository.save(book);
	}

    @Transactional(propagation = Propagation.REQUIRED)
	public void deleteBook(Long bookId) {
        bookRepository.deleteById(bookId);
	}

    @Transactional(propagation = Propagation.REQUIRED)
	public Book updateBook(Book book, Long bookId) {
        Preconditions.checkNotNull(book);
        Preconditions.checkState(book.getId() == bookId);
        Preconditions.checkNotNull(bookRepository.findById(bookId));
		return bookRepository.save(book);
	}

    @Transactional(propagation = Propagation.REQUIRED)
	public Book updateBook(Map<String, String> updates, Long bookId) {
        final Book book = this.findBookById(bookId);
        updates.keySet().forEach(k -> {
            switch(k) {
                case "author":
                    book.updateAuthor(updates.get(k));
                    break;
                case "title":
                    book.updateTitle(updates.get(k));
            }
        });

        return bookRepository.save(book);
	}

    
}