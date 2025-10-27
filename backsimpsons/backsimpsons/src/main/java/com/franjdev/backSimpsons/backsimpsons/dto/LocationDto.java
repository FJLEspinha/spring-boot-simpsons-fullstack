package com.franjdev.backSimpsons.backsimpsons.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LocationDto {
    private Integer id;
    private String name;
    @JsonProperty("image_path")
    private String imagePath;
    private String town;
    private  String use;

    public LocationDto() {

    }

    public LocationDto(Integer id, String name, String imagePath, String town, String use) {
        this.id = id;
        this.name = name;
        this.imagePath = imagePath;
        this.town = town;
        this.use = use;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getImagePath() {
        return imagePath;
    }

    public String getTown() {
        return town != "" ? town : "unknown";
    }

    public String getUse() {
        return use != "" ? use : "unknown";
    }
}
