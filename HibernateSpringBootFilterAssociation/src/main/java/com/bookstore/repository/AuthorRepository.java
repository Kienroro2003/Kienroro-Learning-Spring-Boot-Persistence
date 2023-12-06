package com.bookstore.repository;

import com.bookstore.entity.Author;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
    @Override
    @EntityGraph(value = "author-books-graph",
            type = EntityGraph.EntityGraphType.FETCH)
    Optional<Author> findById(Long aLong);
}
