package com.franjdev.backSimpsons.backsimpsons.controllers;

import com.franjdev.backSimpsons.backsimpsons.dto.EpisodeDto;
import com.franjdev.backSimpsons.backsimpsons.services.EpisodeServices;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/episodes")
public class EpisodeControllers {

    private final EpisodeServices episodeServices;

    public EpisodeControllers(EpisodeServices episodeServices) {
        this.episodeServices =episodeServices;
    }

    @GetMapping
    public Flux<EpisodeDto> getAllEpisodes(@RequestParam(required = false) Integer page) {
        if(page == null) page = 1;
        return episodeServices.getAllEpisodes(page);
    }

    @GetMapping("/{id}")
    public Mono<EpisodeDto> getEpisodeById(@PathVariable Integer id) {
        return episodeServices.getEpisodeById(id);
    }
}
