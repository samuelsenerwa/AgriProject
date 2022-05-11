package com.agesadev.agriproject.model;

public class SearchRequest {
    private String search;

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }

    @Override
    public String toString() {
        return "SearchRequest{" +
                "search='" + search + '\'' +
                '}';
    }
}
