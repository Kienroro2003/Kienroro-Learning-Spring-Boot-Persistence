package com.example.spring_boot_persistence.repositories;

import com.example.spring_boot_persistence.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
}
