package com.franjdev.backSimpsons.backsimpsons.controllers;

import com.franjdev.backSimpsons.backsimpsons.dto.LocationDto;
import com.franjdev.backSimpsons.backsimpsons.services.LocationServices;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/locations")
public class LocationControllers {

    private LocationServices locationServices;

    public LocationControllers(LocationServices locationServices) {
        this.locationServices = locationServices;
    }

    @GetMapping
    public ResponseEntity<Flux<LocationDto>> getAllLocations(Integer page) {
        if(page == null) page = 1;
        return new ResponseEntity<>(locationServices.getAllLocations(page), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Mono<LocationDto>> getLocationById(@PathVariable Integer id) {
        return new ResponseEntity<>(locationServices.getLocationById(id), HttpStatus.OK);
    }
}
