package com.horiienko.domain;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.math.BigDecimal;

public class Book {

    private Long id;

    private String title;

    private String author;

    private String coverPhotoUrl;

    private Long isbnNumber;

    private BigDecimal price;

    private String language;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCoverPhotoUrl() {
        return coverPhotoUrl;
    }

    public void setCoverPhotoUrl(String coverPhotoUrl) {
        this.coverPhotoUrl = coverPhotoUrl;
    }

    public Long getIsbnNumber() {
        return isbnNumber;
    }

    public void setIsbnNumber(Long isbnNumber) {
        this.isbnNumber = isbnNumber;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (!(o instanceof Book)) {
            return false;
        }

        Book book = (Book) o;

        return new EqualsBuilder()
                .append(getId(), book.getId())
                .append(getTitle(), book.getTitle())
                .append(getAuthor(), book.getAuthor())
                .append(getCoverPhotoUrl(), book.getCoverPhotoUrl())
                .append(getIsbnNumber(), book.getIsbnNumber())
                .append(getPrice(), book.getPrice())
                .append(getLanguage(), book.getLanguage())
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(getId())
                .append(getTitle())
                .append(getAuthor())
                .append(getCoverPhotoUrl())
                .append(getIsbnNumber())
                .append(getPrice())
                .append(getLanguage())
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("id", id)
                .append("title", title)
                .append("author", author)
                .append("coverPhotoUrl", coverPhotoUrl)
                .append("isbnNumber", isbnNumber)
                .append("price", price)
                .append("language", language)
                .toString();
    }
}
