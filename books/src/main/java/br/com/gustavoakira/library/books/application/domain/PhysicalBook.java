package br.com.gustavoakira.library.books.application.domain;

import br.com.gustavoakira.library.common.exception.InvalidDomainConversionException;

import java.time.LocalDate;
import java.util.List;

public class PhysicalBook extends Book {
    private String isbn;
    private Integer pages;
    private Integer quantity;

    public PhysicalBook(String id, List<Author> author, String name, LocalDate publicationDate, Double price, String isbn, Integer pages, Integer quantity) {
        super(id, author, name, publicationDate, price);
        this.isbn = isbn;
        this.pages = pages;
        this.quantity = quantity;
    }



    private void validate(){
        if(this.isbn == null ||  this.isbn.isEmpty()){
            throw new InvalidDomainConversionException("ISBN cannot be null or empty");
        }
        if(this.pages == null || this.pages <= 0){
            throw new InvalidDomainConversionException("The number of pages cannot be 0 or null");
        }
        if(this.quantity == null || this.quantity <0){
            throw new InvalidDomainConversionException("The quantity cannot be null or less than 0");
        }
    }

    public String getIsbn() {
        return isbn;
    }

    public Integer getPages() {
        return pages;
    }

    public Integer getQuantity() {
        return quantity;
    }
}
