package br.com.gustavoakira.library.author.application.domain;

import br.com.gustavoakira.library.common.exception.InvalidDomainConversionException;

import java.util.Objects;

public class Author {
    private Long id;
    private String name;
    private String biography;

    public Author(Long id, String name, String biography) {
        this.id = id;
        this.name = name;
        this.biography = biography;
        validate();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getBiography() {
        return biography;
    }

    private void validate(){
        if(this.name == null || this.name.isEmpty()){
            throw new InvalidDomainConversionException("Author's name can't be null or empty");
        }
        if(this.biography == null || this.biography.isEmpty()){
            throw new InvalidDomainConversionException("Author's biography can't be null or empty");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Author author = (Author) o;
        return Objects.equals(id, author.id) && Objects.equals(name, author.name) && Objects.equals(biography, author.biography);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, biography);
    }
}
