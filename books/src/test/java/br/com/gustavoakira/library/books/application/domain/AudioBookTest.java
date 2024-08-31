package br.com.gustavoakira.library.books.application.domain;

import br.com.gustavoakira.library.common.exception.InvalidDomainConversionException;
import org.instancio.Instancio;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AudioBookTest {
    @ParameterizedTest
    @CsvFileSource(resources = "/invalid_audio_book_test.csv",delimiterString = ";",numLinesToSkip = 1)
    void shouldThrowInvalidDomainConversionWhenCreateInvalidAudioBook(String id, String author, String name, LocalDate publicationDate, Double price, String narrator, Double duration){
        List<Author> authors = new ArrayList<>();
        for(String oneAuthor: author.split(",")){
            authors.add(new Author(null,oneAuthor));
        }
        assertThrows(InvalidDomainConversionException.class,()->new AudioBook(id,authors,name, publicationDate, price, narrator, duration));
    }
    @Test
    void shouldCreateAudioBookWhenValid(){
        List<Author> authors = new ArrayList<>();
        authors.add(new Author(null,"akira"));
        assertDoesNotThrow(()->new AudioBook(null,authors,"akira",LocalDate.now(), 200.00,"narrator",2.4));
    }
}