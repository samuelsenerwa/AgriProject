package com.agesadev.agriproject.model;

import java.util.Arrays;

public class DetailedNews {
    private String author;
    private String date;
    private String[] images;
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

    public String[] getImages() {
        return images;
    }

    public void setImages(String[] images) {
        this.images = images;
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
                ", images=" + Arrays.toString(images) +
                ", title='" + title + '\'' +
                '}';
    }
}
