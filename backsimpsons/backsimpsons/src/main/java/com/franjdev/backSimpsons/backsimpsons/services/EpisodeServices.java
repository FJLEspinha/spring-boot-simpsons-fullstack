package com.franjdev.backSimpsons.backsimpsons.services;

import com.franjdev.backSimpsons.backsimpsons.dto.EpisodeDto;
import com.franjdev.backSimpsons.backsimpsons.dto.EpisodeResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class EpisodeServices {

    private final WebClient webClient;

    public EpisodeServices(WebClient webClient) {
        this.webClient = webClient;
    }

    public Flux<EpisodeDto> getAllEpisodes(Integer page){
        return webClient.get().uri("/episodes?page="+page).retrieve()
                .bodyToMono(EpisodeResponse.class)
                .map(EpisodeResponse :: getResults)
                .flatMapMany(Flux::fromIterable);
    }

    public Mono<EpisodeDto> getEpisodeById(Integer id) {
        return webClient.get().uri("/episodes/"+id).retrieve()
                .bodyToMono(EpisodeDto.class);
    }

}
