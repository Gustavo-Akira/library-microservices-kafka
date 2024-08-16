package br.com.gustavoakira.library.users.application.exception;

public class InvalidDomainConversionException extends RuntimeException{
    public InvalidDomainConversionException(String message) {
        super(message);
    }
}
