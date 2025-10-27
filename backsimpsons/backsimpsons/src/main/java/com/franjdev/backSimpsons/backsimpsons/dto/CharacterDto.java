package com.franjdev.backSimpsons.backsimpsons.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
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
    //@JsonProperty("portrait_path")
    private final String portraitPath;
/*
    public  CharacterDto() {

    }

 */

    public CharacterDto(
            @JsonProperty("id") Integer id, @JsonProperty("age") Integer age,
            @JsonProperty("birthdate") String birthdate, @JsonProperty("name") String name,
            @JsonProperty("description") String description, @JsonProperty("gender") String gender,
            @JsonProperty("occupation") String occupation, @JsonProperty("status") String status,
            @JsonProperty("portrait_path") String portraitPath) {
        this.id = id;
        this.age = age;
        this.birthdate = birthdate;
        this.name = name;
        this.description = description;
        this.gender = gender;
        this.occupation = occupation;
        this.status = status;
        this.portraitPath = portraitPath;
    }

    public Integer getId() {
        return id;
    }

    public Integer getAge() {
        return age ;
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
        return  description;
    }

    public String getGender() {
        return gender;
    }
}
