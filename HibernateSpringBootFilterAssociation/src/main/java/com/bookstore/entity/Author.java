package com.bookstore.entity;

import java.io.Serializable;
import java.util.*;
import javax.persistence.*;

import org.hibernate.annotations.Where;

@Entity
@NamedEntityGraph(
        name = "author-books-graph",
        attributeNodes = {
                @NamedAttributeNode(value = "cheapBooks"),
                @NamedAttributeNode(value = "restOfBooks")
        }
)
public class Author implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String genre;
    private int age;

    @OneToMany(cascade = CascadeType.ALL,
            mappedBy = "author", orphanRemoval = true)
    private List<Book> books = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL,
            mappedBy = "author", orphanRemoval = true)
    @Where(clause = "price <= 20")
    private Set<Book> cheapBooks = new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL,
            mappedBy = "author", orphanRemoval = true)
    @Where(clause = "price > 20")
    private Set<Book> restOfBooks = new HashSet<>();

    public void addBook(Book book) {
        this.books.add(book);
        book.setAuthor(this);
    }

    public void removeBook(Book book) {
        book.setAuthor(null);
        this.books.remove(book);
    }

    public void removeBooks() {
        Iterator<Book> iterator = this.books.iterator();

        while (iterator.hasNext()) {
            Book book = iterator.next();

            book.setAuthor(null);
            iterator.remove();
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Set<Book> getCheapBooks() {
        return cheapBooks;
    }

    public void setCheapBooks(Set<Book> cheapBooks) {
        this.cheapBooks = cheapBooks;
    }

    public Set<Book> getRestOfBooks() {
        return restOfBooks;
    }

    public void setRestOfBooks(Set<Book> restOfBooks) {
        this.restOfBooks = restOfBooks;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    @Override
    public String toString() {
        return "Author{" + "id=" + id + ", name=" + name
                + ", genre=" + genre + ", age=" + age + '}';
    }

}
