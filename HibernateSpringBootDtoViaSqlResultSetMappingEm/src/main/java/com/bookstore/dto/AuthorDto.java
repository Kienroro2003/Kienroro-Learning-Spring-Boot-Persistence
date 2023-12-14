package com.bookstore.dto;

import java.io.Serializable;

public class AuthorDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private final String name;
//    private final int age;
    private final String genre;

    public AuthorDto(String name, String genre) {
        this.name = name;
        this.genre = genre;
    }

    public String getName() {
        return name;
    }

    public String getGenre() {
        return genre;
    }
}
