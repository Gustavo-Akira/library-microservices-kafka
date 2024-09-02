package br.com.gustavoakira.library.author.application.domain;

import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class AuthorTest {
    @Test
    void shouldCreateAuthorWhenInformationIsValid(){
        assertDoesNotThrow(()->new Author(null,"Akira","sfsadfs"));
        assertDoesNotThrow(()->new Author(1L,"Akira","a"));
    }
}