package com.agesadev.agriproject.model;

import java.util.Objects;

public class SearchResponse {
    private String author;
    private String image;
    private String link;
    private String text;
    private String title;

    public SearchResponse(String author, String image, String link, String text, String title) {
        this.author = author;
        this.image = image;
        this.link = link;
        this.text = text;
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "SearchResponse{" +
                "author='" + author + '\'' +
                ", image='" + image + '\'' +
                ", link='" + link + '\'' +
                ", text='" + text + '\'' +
                ", title='" + title + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SearchResponse that = (SearchResponse) o;
        return Objects.equals(author, that.author) && Objects.equals(image, that.image) && Objects.equals(link, that.link) && Objects.equals(text, that.text) && Objects.equals(title, that.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(author, image, link, text, title);
    }
}
