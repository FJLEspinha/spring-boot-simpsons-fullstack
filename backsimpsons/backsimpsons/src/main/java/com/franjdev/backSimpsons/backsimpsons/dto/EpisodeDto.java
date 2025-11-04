package com.franjdev.backSimpsons.backsimpsons.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class EpisodeDto {
    private final Integer id;
    private final String airdate;
    @JsonProperty("image_path")
    private final String imagePath;
    private final String name;
    private final Integer season;
    private final String synopsis;

    public EpisodeDto(
            Integer id, String airdate,
            String imagePath, String name,
            Integer season, String synopsis) {
        this.id = id;
        this.airdate = airdate;
        this.imagePath = imagePath;
        this.name = name;
        this.season = season;
        this.synopsis = synopsis;
    }

    public Integer getId() {
        return id;
    }

    public String getAirdate() {
        return airdate;
    }

    public String getImagePath() {
        return imagePath;
    }

    public String getName() {
        return name;
    }

    public Integer getSeason() {
        return season;
    }

    public String getSynopsis() {
        return synopsis;
    }
}
