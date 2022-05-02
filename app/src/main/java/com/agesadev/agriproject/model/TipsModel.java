package com.agesadev.agriproject.model;


public class TipsModel {
    private String author;
    private String image;
    private String link;
    private String text;
    private String title;

    public TipsModel(String author, String image, String link, String text, String title) {
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
        return "TipsModel{" +
                "author='" + author + '\'' +
                ", image='" + image + '\'' +
                ", link='" + link + '\'' +
                ", text='" + text + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}
