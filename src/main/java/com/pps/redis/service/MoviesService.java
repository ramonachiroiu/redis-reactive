package com.pps.redis.service;

import com.pps.redis.entity.MovieDetails;
import com.pps.redis.repository.MoviesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class MoviesService {

    @Autowired
    private MoviesRepository repository;

    public Flux<MovieDetails> getMovieDetails() {
        return repository.findAll();
    }

    public Mono<Long> addMovieDetails(MovieDetails movie) {
        return repository.save(movie);
    }

    public void deleteAll() {
        repository.deleteAll();
    }
}
