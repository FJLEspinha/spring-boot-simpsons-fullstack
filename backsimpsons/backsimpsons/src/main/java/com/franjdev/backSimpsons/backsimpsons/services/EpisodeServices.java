package com.franjdev.backSimpsons.backsimpsons.services;

import com.franjdev.backSimpsons.backsimpsons.dto.EpisodeDto;
import com.franjdev.backSimpsons.backsimpsons.dto.EpisodeResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

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

    public Flux<EpisodeDto> getEpisodesBySeason(Integer seasonNumber) {
        return retrieveAllPages("/episodes?page=1")
                .filter(episode -> episode.getSeason().equals(seasonNumber));
    }

    public Flux<EpisodeDto> retrieveAllPages(String url) {
        return webClient.get().uri(url).retrieve()
                .bodyToMono(EpisodeResponse.class)
                .flatMapMany( response -> {
                    Flux<EpisodeDto> currentEpisodes = Flux.fromIterable(response.getResults());

                    String nextUrl = response.getNext();

                    if(nextUrl != null) {
                        Flux<EpisodeDto> nextEpisodes = retrieveAllPages(nextUrl);
                        return Flux.concat(currentEpisodes,nextEpisodes);
                    }else {
                        return currentEpisodes;
                    }
                });
    }

}
