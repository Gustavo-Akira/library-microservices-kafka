package br.com.gustavoakira.library.author.adapters.dto;

import br.com.gustavoakira.library.author.application.domain.Author;
import jakarta.validation.constraints.NotEmpty;

public record SaveAuthorDTO(@NotEmpty String name, @NotEmpty String biography){
    public Author toDomain(){
        return new Author(null,name,biography);
    }
}
