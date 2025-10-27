package com.franjdev.backSimpsons.backsimpsons.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class CharacterResponse {
    private final Integer count;
    private final String next;
    private final String back;
    private final Integer pages;
    private final List<CharacterDto> results;

    @JsonCreator
    public CharacterResponse(
            @JsonProperty("count") Integer count, @JsonProperty("next") String next,
            @JsonProperty("back") String back, @JsonProperty("pages") Integer pages,
            @JsonProperty("results") List<CharacterDto> results) {
        this.count = count;
        this.next = next;
        this.back = back;
        this.pages = pages;
        this.results = results;
    }

    public Integer getCount() {
        return count;
    }

    public String getNext() {
        return next != null ? next : "No more pages";
    }

    public String getBack() {
        return back != null ? back : "This is the first page";
    }

    public Integer getPages() {
        return pages;
    }

    public List<CharacterDto> getResults() {
        return results;
    }
}
