package com.pps.redis.controller;

import com.pps.redis.entity.MovieDetails;
import com.pps.redis.service.MoviesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class MoviesController {

    @Autowired
    private MoviesService service;

    @GetMapping(produces = { MediaType.APPLICATION_JSON_VALUE }, value = "/movie-details")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Flux<MovieDetails>> getMovieDetails() {
        return new ResponseEntity<>(service.getMovieDetails(), HttpStatus.OK);
    }

    @PostMapping(produces = { MediaType.APPLICATION_JSON_VALUE }, value = "/movie-details")
    public ResponseEntity<Mono<Long>> addMovieDetails(@RequestBody MovieDetails movieDetails) {
        return new ResponseEntity<>(service.addMovieDetails(movieDetails), HttpStatus.CREATED);
    }

    @DeleteMapping("/all")
    public void deleteAllMovies() {
        service.deleteAll();
    }
}
