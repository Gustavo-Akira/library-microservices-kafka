package br.com.gustavoakira.library.books.application.domain;

import br.com.gustavoakira.library.common.exception.InvalidDomainConversionException;

import java.time.LocalDate;
import java.util.List;

public class EBook extends Book {
    private Integer pages;
    private String downloadUrl;
    private Double fileSize;

    public EBook(String id, List<Author> author, String name, LocalDate publicationDate, Double price, Integer pages, String downloadUrl, Double fileSize) {
        super(id, author, name, publicationDate, price);
        this.pages = pages;
        this.downloadUrl = downloadUrl;
        this.fileSize = fileSize;
    }

    private void validate(){
        if(this.pages == null || this.pages <= 0){
            throw new InvalidDomainConversionException("The number of pages cannot be 0 or null");
        }
        if(this.fileSize == null || this.fileSize <= 0){
            throw new InvalidDomainConversionException("The file size cannot be 0 or null");
        }
        if(this.downloadUrl == null || this.downloadUrl.isEmpty()){
            throw new InvalidDomainConversionException("The download url cannot be null or empty");
        }
    }

    public int getPages() {
        return pages;
    }

    public String getDownloadUrl() {
        return downloadUrl;
    }

    public double getFileSize() {
        return fileSize;
    }
}
