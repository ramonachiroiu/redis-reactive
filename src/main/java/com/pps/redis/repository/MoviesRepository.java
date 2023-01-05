package com.pps.redis.repository;


import com.pps.redis.entity.MovieDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.ReactiveRedisOperations;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
@RequiredArgsConstructor
public class MoviesRepository {

    public static final String MOVIES = "movies";
    private final ReactiveRedisOperations<String, MovieDetails> reactiveRedisOperations;

    public Flux<MovieDetails> findAll(){
        return reactiveRedisOperations.opsForList().range(MOVIES, 0, -1);
    }

    public Mono<Long> save(MovieDetails movie){
        return reactiveRedisOperations.opsForList().rightPush(MOVIES, movie);
    }


    public Mono<Long> deleteAll() {
        return reactiveRedisOperations.delete(MOVIES);
    }
}
