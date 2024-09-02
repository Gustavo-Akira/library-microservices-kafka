package br.com.gustavoakira.library.author.adapters.dto;

import br.com.gustavoakira.library.author.application.domain.Author;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record UpdateAuthorDTO(@NotNull Long id, @NotEmpty String name, @NotEmpty String biography){
    public Author toDomain(){
        return new Author(id,name,biography);
    }
}
