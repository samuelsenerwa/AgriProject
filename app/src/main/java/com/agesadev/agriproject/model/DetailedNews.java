package com.agesadev.agriproject.model;

import java.util.Arrays;

public class DetailedNews {
    private String author;
    private String date;
    private String[] text;
    private String image;
    private String title;

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String[] getText() {
        return text;
    }

    public void setText(String[] text) {
        this.text = text;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "DetailedNews{" +
                "author='" + author + '\'' +
                ", date='" + date + '\'' +
                ", text=" + Arrays.toString(text) +
                ", image='" + image + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}
