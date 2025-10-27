package com.franjdev.backSimpsons.backsimpsons.services;

import com.franjdev.backSimpsons.backsimpsons.dto.LocationDto;
import com.franjdev.backSimpsons.backsimpsons.dto.LocationsResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class LocationServices {

    private final WebClient webClient;

    public LocationServices(WebClient webClient){
        this.webClient = webClient;
    }

    public Mono<LocationDto> getLocationById(Integer id) {
        return webClient.get().uri("/locations/"+id).retrieve().bodyToMono(LocationDto.class);
    }

    public Flux<LocationDto> getAllLocations(Integer page) {
        return webClient.get().uri("/locations?page="+page).retrieve()
                .bodyToMono(LocationsResponse.class)
                .map(LocationsResponse::getResults)
                .flatMapMany(Flux::fromIterable);
    }
}
