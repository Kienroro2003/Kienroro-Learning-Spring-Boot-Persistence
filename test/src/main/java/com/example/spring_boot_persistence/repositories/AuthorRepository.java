package com.example.spring_boot_persistence.repositories;

import com.example.spring_boot_persistence.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(readOnly=true)
public interface AuthorRepository extends JpaRepository<Author, Long> {
    @Query("SELECT a FROM Author a JOIN FETCH a.books WHERE a.name = ?1")
    Author fetchByName(String name);
    @Query("SELECT a FROM Author a JOIN a.books WHERE a.name = ?1")
    Author getByName(String name);
}
