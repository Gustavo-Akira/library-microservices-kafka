package br.com.gustavoakira.library.users.application.domain;

import br.com.gustavoakira.library.common.exception.InvalidDomainConversionException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {
    @ParameterizedTest
    @MethodSource("provideInvalidUserParameters")
    void shouldThrowValidationExceptionWhenUserIsInvalid(Long id, String name, String email, String password){
        assertAll(
                ()->assertThrows(InvalidDomainConversionException.class,()->new User(id,name,email,password)),
                ()->assertThrows(InvalidDomainConversionException.class,()->new User(name,email,password))
        );

    }

    @Test
    void shouldCreateUserWhenValidUser(){
        assertDoesNotThrow(()->new User(1L,"akira","email@email.com","password"));
    }

    private static Stream<Arguments> provideInvalidUserParameters() {
        return Stream.of(
                Arguments.of(null, "af",null,null),
                Arguments.of(null, null,null,null),
                Arguments.of(null, "af","sfa",null),
                Arguments.of(null, null,"asfaf","fasfas"),
                Arguments.of(null, "","",""),
                Arguments.of(null, "","","sfsadf"),
                Arguments.of(null, "","adsfdfsa","afsddf"),
                Arguments.of(null, "asdfdfs","","asdfdf")
        );
    }


}