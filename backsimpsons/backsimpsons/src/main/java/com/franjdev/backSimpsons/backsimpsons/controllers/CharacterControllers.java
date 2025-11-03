package com.franjdev.backSimpsons.backsimpsons.controllers;

import com.franjdev.backSimpsons.backsimpsons.dto.CharacterDto;
import com.franjdev.backSimpsons.backsimpsons.services.CharacterServices;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@RestController
@RequestMapping("/characters")
public class CharacterControllers {

    private final CharacterServices characterServices;

    public CharacterControllers(CharacterServices characterServices) {
        this.characterServices = characterServices;
    }

    @GetMapping
    public Flux<CharacterDto> getAllCharacters(Integer page) {
        if (page == null) page = 1;
        return characterServices.getAllCharacters(page);
    }

    @GetMapping("/{id}")
    public Mono<CharacterDto> getCharacterById(@PathVariable Integer id) {
        return characterServices.getCharacterById(id);
    }

    @GetMapping("/by-name")
    public Mono<CharacterDto> getCharacterByName(@RequestParam(defaultValue = "Homer") String name) {
        return characterServices.getCharacterByName(name);
    }
}
