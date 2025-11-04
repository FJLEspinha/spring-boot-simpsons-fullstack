package com.franjdev.backSimpsons.backsimpsons.dto;

import java.util.List;

public class EpisodeResponse {
    private final Integer count;
    private final String next;
    private final String prev;
    private final Integer pages;
    private final List<EpisodeDto> results;

    public EpisodeResponse(
            Integer count, String next,
            String prev, Integer pages,
            List<EpisodeDto> results) {
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
        return next;
    }

    public String getPrev() {
        return prev;
    }

    public Integer getPages() {
        return pages;
    }

    public List<EpisodeDto> getResults() {
        return results;
    }
}
