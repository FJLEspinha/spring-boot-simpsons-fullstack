package com.franjdev.backSimpsons.backsimpsons.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CharacterDto {

    private final Integer id;
    private final Integer age;
    private final String birthdate;
    private final String name;
    private final String description;
    private final String gender;
    private final String occupation;
    private final String status;
    @JsonProperty("portrait_path")
    private final String portraitPath;
    @JsonProperty("first_appearance_ep")
    private final FirstAppearanceEpisodeDto firstAppearanceEpisode;


    public CharacterDto(
            Integer id, Integer age,
            String birthdate, String name,
            String description, String gender,
            String occupation, String status,
            String portraitPath,
            FirstAppearanceEpisodeDto firstAppearanceEpisode) {
        this.id = id;
        this.age = age;
        this.birthdate = birthdate;
        this.name = name;
        this.description = description;
        this.gender = gender;
        this.occupation = occupation;
        this.status = status;
        this.portraitPath = portraitPath;
        this.firstAppearanceEpisode = firstAppearanceEpisode;
    }

    public Integer getId() {
        return id;
    }

    public Integer getAge() {
        return age;
    }

    public String getBirthdate() {
        return birthdate != null ? birthdate : "unknown";
    }

    public String getName() {
        return name;
    }

    public String getOccupation() {
        return occupation;
    }

    public String getStatus() {
        return status;
    }

    public String getPortraitPath() {
        return portraitPath;
    }

    public String getDescription() {
        return description;
    }

    public String getGender() {
        return gender;
    }

    public Integer getFirstAppearanceEpisodeId() {
        return firstAppearanceEpisode != null ? firstAppearanceEpisode.getId() : null;
    }


}
