package com.bookstore.service;

import com.bookstore.repository.AuthorRepository;
import com.bookstore.entity.Author;
import com.bookstore.entity.Book;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BookstoreService {

    private final AuthorRepository authorRepository;

    public BookstoreService(AuthorRepository authorRepository) {

        this.authorRepository = authorRepository;
    }

    private void displayBooks(Set<Book> books){
        books.stream().forEach(System.out::println);
    }

    private void displayBooks(List<Book> books){
        books.stream().forEach(System.out::println);
    }

    @Transactional(readOnly = true)
    public void fetchAuthorWithAllBooks() {

        Author author = authorRepository.findById(1L).orElseThrow();
        List<Book> books = author.getBooks();

        displayBooks(books);
    }

    @Transactional(readOnly = true)
    public void fetchAuthorWithCheapBooks() {

        Author author = authorRepository.findById(1L).orElseThrow();
        Set<Book> books = author.getCheapBooks();

        displayBooks(books);
    }

    @Transactional(readOnly = true)
    public void fetchAuthorWithRestOfBooks() {

        Author author = authorRepository.findById(1L).orElseThrow();
        Set<Book> books = author.getRestOfBooks();

        displayBooks(books);
    }
}
