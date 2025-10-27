package com.franjdev.backSimpsons.backsimpsons.dto;

import java.util.List;

public class LocationsResponse {
    private Integer count;
    private  String next;
    private String prev;
    private Integer pages;
    private List<LocationDto> results;

    public LocationsResponse(Integer count, String next, String prev, Integer pages, List<LocationDto> results) {
        this.count = count;
        this.next = next;
        this.prev = prev;
        this.pages = pages;
        this.results = results;
    }

    public Integer getCount() {
        return count;
    }

    public String getNext() {
        return next != null ? next : "No more pages";
    }

    public String getPrev() {
        return prev != null ? prev : "This is the first page";
    }

    public Integer getPages() {
        return pages;
    }

    public List<LocationDto> getResults() {
        return results;
    }
}
