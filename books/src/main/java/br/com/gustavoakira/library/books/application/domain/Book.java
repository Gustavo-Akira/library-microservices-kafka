package br.com.gustavoakira.library.books.application.domain;

import br.com.gustavoakira.library.common.exception.InvalidDomainConversionException;

import java.time.LocalDate;
import java.util.List;

public abstract class Book {
    private String id;
    private List<Author> author;
    private String name;
    private LocalDate publicationDate;
    private Double price;

    public Book(String id, List<Author> author, String name, LocalDate publicationDate, Double price) {
        this.id = id;
        this.author = author;
        this.name = name;
        this.publicationDate = publicationDate;
        this.price = price;
        validate();
    }

    public String getId() {
        return id;
    }

    public List<Author> getAuthor() {
        return author;
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    public LocalDate getPublicationDate() {
        return publicationDate;
    }
    private void validate(){
        if(this.author == null || this.author.isEmpty()){
            throw new InvalidDomainConversionException("Author Cannot be null or empty");
        }
        if(this.name == null || this.name.isEmpty()) {
            throw new InvalidDomainConversionException("Name Cannot be null or empty");
        }
        if(this.publicationDate == null || this.publicationDate.isAfter(LocalDate.now())) {
            throw new InvalidDomainConversionException("Publication Date cannot be null or in the future");
        }
        if(this.price == null || this.price <=0){
            throw new InvalidDomainConversionException("Price cannot be null or minor equal to 0 ");
        }
    }
}
