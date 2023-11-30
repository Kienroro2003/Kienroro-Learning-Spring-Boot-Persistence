package com.example.spring_boot_persistence.services;

import com.example.spring_boot_persistence.model.Author;
import com.example.spring_boot_persistence.model.Book;
import com.example.spring_boot_persistence.repositories.BookRepository;
import org.springframework.stereotype.Service;

@Service
public class BookService {
    private BookRepository bookRepository;

    public void insertAuthorWithBooks() {

        Author author = new Author();
        author.setName("Alicia Tom");
        author.setAge(38);
        author.setGenre("Anthology");

        Book book = new Book();
        book.setIsbn("001-AT");
        book.setTitle("The book of swords");

        author.addBook(book); // use addBook() helper

//        authorRepository.save(author);
    }
}
