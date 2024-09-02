package br.com.gustavoakira.library.author.adapters.dto;

import br.com.gustavoakira.library.author.application.domain.Author;


public record AuthorReturnDTO(Long id, String name, String biography){
    public static AuthorReturnDTO fromDomain(Author author){
        return new AuthorReturnDTO(author.getId(), author.getName(), author.getBiography());
    }
}
