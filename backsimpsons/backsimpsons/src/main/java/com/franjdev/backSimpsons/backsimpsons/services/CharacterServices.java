package com.franjdev.backSimpsons.backsimpsons.services;

import com.franjdev.backSimpsons.backsimpsons.dto.CharacterDto;
import com.franjdev.backSimpsons.backsimpsons.dto.CharacterResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class CharacterServices {

    private final WebClient webClient;


    public  CharacterServices(WebClient webClient) {
        this.webClient = webClient;
    }

    public  Mono<CharacterDto> getCharacterById(Integer id) {
        return webClient.get().uri("/characters/" + id).retrieve().bodyToMono(CharacterDto.class);
    }

    public Flux<CharacterDto> getAllCharacters(Integer page) {
        return webClient.get().uri("/characters?page="+page).retrieve()
                .bodyToMono(CharacterResponse.class)
                .map(CharacterResponse::getResults)
                .flatMapMany(Flux::fromIterable);

    }
}
