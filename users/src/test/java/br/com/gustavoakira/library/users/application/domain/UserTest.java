package br.com.gustavoakira.library.users.application.domain;

import br.com.gustavoakira.library.users.application.domain.exception.InvalidDomainConversionException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {
    @ParameterizedTest
    @MethodSource("provideInvalidUserParameters")
    void shouldThrowValidationExceptionWhenUserIsInvalid(Long id, String name, String email, String password, Role role){
        assertAll(
                ()->assertThrows(InvalidDomainConversionException.class,()->new User(id,name,email,password,role)),
                ()->assertThrows(InvalidDomainConversionException.class,()->new User(name,email,password,role))
        );

    }

    @Test
    void shouldCreateUserWhenValidUser(){
        assertDoesNotThrow(()->new User(1L,"akira","email@email.com","password",null));
    }

    private static Stream<Arguments> provideInvalidUserParameters() {
        return Stream.of(
                Arguments.of(null, "af",null,null,null),
                Arguments.of(null, null,null,null,null),
                Arguments.of(null, "af","sfa",null,null),
                Arguments.of(null, null,"asfaf","fasfas",null),
                Arguments.of(null, "","","",null),
                Arguments.of(null, "","","sfsadf",null),
                Arguments.of(null, "","adsfdfsa","afsddf",null),
                Arguments.of(null, "asdfdfs","","asdfdf",null)
        );
    }


}