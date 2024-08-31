package br.com.gustavoakira.library.books.application.domain;

import br.com.gustavoakira.library.common.exception.InvalidDomainConversionException;

import java.time.LocalDate;
import java.util.List;

public class AudioBook extends Book{
    private String narrator;
    private Double duration;
    public AudioBook(String id, List<Author> author, String name, LocalDate publicationDate,Double price,String narrator, Double duration) {
        super(id, author, name, publicationDate,price);
        this.narrator = narrator;
        this.duration = duration;
        validate();
    }

    public String getNarrator() {
        return narrator;
    }

    public double getDuration() {
        return duration;
    }

    private void validate(){
        if(this.duration == null || this.duration <=0){
            throw new InvalidDomainConversionException("Duration cannot be null or minor equal to 0 ");
        }
        if(this.narrator == null ||this.narrator.isEmpty()){
            throw new InvalidDomainConversionException("Narrator cannot be null or empty");
        }
    }
}
