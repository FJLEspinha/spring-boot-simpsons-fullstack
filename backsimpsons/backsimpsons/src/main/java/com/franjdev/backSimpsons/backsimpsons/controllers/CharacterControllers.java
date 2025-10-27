package com.franjdev.backSimpsons.backsimpsons.controllers;

import com.franjdev.backSimpsons.backsimpsons.dto.CharacterDto;
import com.franjdev.backSimpsons.backsimpsons.services.CharacterServices;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequestMapping("/characters")
public class CharacterControllers {

    private final CharacterServices characterServices;

    public  CharacterControllers(CharacterServices characterServices) {
        this.characterServices = characterServices;
    }
    @GetMapping
    public ResponseEntity<Flux<CharacterDto>> getAllCharacters(Integer page ) {
        if (page == null) page = 1;
        return new ResponseEntity<>(characterServices.getAllCharacters(page), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Mono<CharacterDto>> getCharacterById(@PathVariable Integer id) {
        return new ResponseEntity<>(characterServices.getCharacterById(id),HttpStatus.OK);
    }
}
