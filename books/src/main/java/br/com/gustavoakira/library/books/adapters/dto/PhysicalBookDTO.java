package br.com.gustavoakira.library.books.adapters.dto;

import br.com.gustavoakira.library.books.application.domain.Book;

public record PhysicalBookDTO(String id) {
    public static PhysicalBookDTO fromDomain(Book book){
        return new PhysicalBookDTO(book.getId());
    }
}
