package br.com.gustavoakira.library.books.application.domain;

import br.com.gustavoakira.library.common.exception.InvalidDomainConversionException;

public class Author {
    private String id;
    private String name;

    public Author(String id, String name) {
        this.id = id;
        this.name = name;
        validate();
    }

    private void validate(){
        if(this.name == null || this.name.isEmpty()){
            throw new InvalidDomainConversionException("Author name cannot be null or empty");
        }
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
