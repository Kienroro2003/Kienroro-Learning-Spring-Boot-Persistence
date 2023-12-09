package com.bookstore.repository;

import com.bookstore.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
//@Transactional(readOnly = true)
//@Transactional
public interface AuthorRepository extends JpaRepository<Author, Long> {
//    @Query("SELECT a FROM Author a WHERE a.id = ?1")
//    public Optional<Author> fetchById(long id);
}
