package br.com.gustavoakira.library.users.application.domain;

import br.com.gustavoakira.library.users.application.domain.exception.InvalidDomainConversionException;
import jakarta.xml.bind.ValidationException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RoleTest {

    @Test
    void shouldThrowValidationExceptionWhenNameIsNull(){
         assertThrows(InvalidDomainConversionException.class,()-> new Role(null));
        assertThrows(InvalidDomainConversionException.class, ()->new Role(1L,null));
    }

    @Test
    void shouldThrowValidationExceptionWhenNameIsEmpty(){
        assertThrows(InvalidDomainConversionException.class, ()->new Role(""));
        assertThrows(InvalidDomainConversionException.class, ()->new Role(1L,""));
    }

    @Test
    void shouldCreateRoleWhenNameIsValid(){
        assertDoesNotThrow(()->new Role("admin"));
        assertDoesNotThrow(()->new Role(1L,"admin"));
    }


    @Test
    void shouldReturnRoleNameWhenGetNameIsCalled(){
        String name = "admin";
        assertEquals("admin", new Role(name).getName());
    }

    @Test
    void shouldReturnRoleNIdWhenGetIdIsCalled() {
        String name = "admin";
        Long id = 1L;
        assertEquals(id, new Role(id,name).getId());
    }


}