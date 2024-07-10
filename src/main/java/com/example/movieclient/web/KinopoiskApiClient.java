package com.example.movieclient.web;

import com.example.movieclient.models.Movie;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@FeignClient(name = "KinopoiskApiClient", url = "http://localhost:8081/movies")
public interface KinopoiskApiClient {

    @GetMapping("/{id}")
    Movie findById(@PathVariable("id") Long id);

    @GetMapping("/search")
    List<Movie> findByPageByName(
            @RequestParam(value = "page", required = false, defaultValue = "1") int page,
            @RequestParam(value = "limit", required = false, defaultValue = "10") int limit,
            @RequestParam(value = "name") String name
    );

    @GetMapping("/rating")
    List<Movie> findByPageByRating(
            @RequestParam(value = "page", required = false, defaultValue = "1") int page,
            @RequestParam(value = "limit", required = false, defaultValue = "10") int limit,
            @RequestParam(value = "rating.kp") String rating
    );

    @GetMapping("/genre")
    List<Movie> findByPageByGenre(
            @RequestParam(value = "page", required = false, defaultValue = "1") int page,
            @RequestParam(value = "limit", required = false, defaultValue = "10") int limit,
            @RequestParam(value = "genres.name") String genre
    );
}

