package com.agesadev.agriproject.model;

public class SearchRequest {
    private String data;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "SearchRequest{" +
                "data='" + data + '\'' +
                '}';
    }

}
