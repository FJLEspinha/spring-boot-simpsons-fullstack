package com.franjdev.backSimpsons.backsimpsons.services;

import com.franjdev.backSimpsons.backsimpsons.dto.CharacterDto;
import com.franjdev.backSimpsons.backsimpsons.dto.CharacterResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


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

    public Mono<CharacterDto> getCharacterByName(String name) {
        return findCharacterByName("/characters", name);
    }

    private Mono<CharacterDto> findCharacterByName(String url, String targetName) {
        if(url == null || url.equals("No more pages")) {
            return Mono.empty();
        }

        return webClient.get().uri(url).retrieve()
                .bodyToMono(CharacterResponse.class)
                .flatMap(response -> {
                    CharacterDto foundCharacter = response.getResults().stream()
                            .filter(character -> character.getName().toLowerCase().contains(targetName.toLowerCase()))
                            .findFirst()
                            .orElse(null);

                    if(foundCharacter != null) {
                        Integer characterId = foundCharacter.getId();
                        if(characterId != null) {
                            return getCharacterById(characterId);
                        }else {
                            return  Mono.just(foundCharacter);
                        }
                    }else {
                        return findCharacterByName(response.getNext(),targetName);
                    }
                });
    }
}
