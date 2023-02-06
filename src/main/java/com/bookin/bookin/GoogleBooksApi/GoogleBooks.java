package com.bookin.bookin.GoogleBooksApi;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown=true)
public class GoogleBooks {

    private int totalItems;
    private List<ApiWrapper> items;


    public int getTotalItems() {
        return totalItems;
    }

    public void setTotalItems(int totalItems) {
        this.totalItems = totalItems;
    }

    public List<ApiWrapper> getItems() {
        return items;
    }

    public void setItems(List<ApiWrapper> items) {
        this.items = items;
    }


}
