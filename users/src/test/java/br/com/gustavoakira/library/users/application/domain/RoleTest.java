package br.com.gustavoakira.library.users.application.domain;

import jakarta.xml.bind.ValidationException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RoleTest {

    @Test
    void shouldThrowValidationExceptionWhenNameIsNull(){
         assertThrows(Exception.class, new Role(null));
        assertThrows(Exception.class, new Role(1L,null));
    }

    @Test
    void shouldThrowValidationExceptionWhenNameIsEmpty(){
        assertThrows(Exception.class, new Role(""));
        assertThrows(Exception.class, new Role(1L,""));
    }

    @Test
    void shouldCreateRoleWhenNameIsValid(){
        assertThrows(Exception.class, new Role("admin"));
        assertThrows(Exception.class, new Role(1L,"admin"));
    }

}