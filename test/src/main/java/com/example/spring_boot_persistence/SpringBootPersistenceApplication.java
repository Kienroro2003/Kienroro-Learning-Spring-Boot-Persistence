package com.example.spring_boot_persistence;

import com.example.spring_boot_persistence.services.BookstoreService;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;

@SpringBootApplication()
public class SpringBootPersistenceApplication {

    private final BookstoreService bookstoreService;

    public SpringBootPersistenceApplication(BookstoreService bookstoreService) {
        this.bookstoreService = bookstoreService;
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringBootPersistenceApplication.class, args);
    }

    @Bean
    public ApplicationRunner init() {
        return args -> {
            System.out.println("\nInsert author with books  ...");
            bookstoreService.insertAuthorWithBooks();

            System.out.println("\nDelete a book of an author...");
            bookstoreService.deleteBookOfAuthor();

//            System.out.println("\nDelete all book of an author...");
//            bookstoreService.deleteAllBooksOfAuthor();
        };
    }

}




