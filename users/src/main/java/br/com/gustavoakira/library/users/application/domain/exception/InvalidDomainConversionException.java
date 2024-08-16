package br.com.gustavoakira.library.users.application.domain.exception;

public class InvalidDomainConversionException extends RuntimeException{
    public InvalidDomainConversionException(String message) {
        super(message);
    }
}
