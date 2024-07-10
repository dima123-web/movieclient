package com.example.movieclient.web;

import com.example.movieclient.models.Movie;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@AllArgsConstructor
@RequestMapping("/movies")
@Tag(name = "Controller for work with movies", description = "API для поиска фильмов, по указанным параметрам")
public class MovieController {

    private KinopoiskApiClient kinopoiskApiClient;

    @Operation(summary = "Поиск фильма по ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Найденный фильм",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Movie.class))})
    })

    @GetMapping("/{id}")
    public Movie getById(@Parameter(description = "ID фильма") @PathVariable("id") Long id) {
        return kinopoiskApiClient.findById(id);
    }

    @Operation(summary = "Поиск фильмов по названию, с определенным количеством страниц")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Список фильмов",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Movie.class))})
    })

    @GetMapping("/search")
    public List<Movie> getByPageByName(
            @Parameter(description = "Страница выборки") @RequestParam(value = "page", required = false, defaultValue = "1") int page,
            @Parameter(description = "Количество элементов на странице") @RequestParam(value = "limit", required = false, defaultValue = "10") int limit,
            @Parameter(description = "Название фильма") @RequestParam(value = "name") String name
    ) {
        return kinopoiskApiClient.findByPageByName(page, limit, name);
    }

    @Operation(summary = "Поиск фильмов с указанным рейтингом")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Список фильмов",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Movie.class))})
    })

    @GetMapping("/rating")
    public List<Movie> getByPageByRating(
            @Parameter(description = "Страница выборки") @RequestParam(value = "page", required = false, defaultValue = "1") int page,
            @Parameter(description = "Количество элементов на странице") @RequestParam(value = "limit", required = false, defaultValue = "10") int limit,
            @Parameter(description = "Рейтинг фильма") @RequestParam(value = "rating.kp") String rating
    ) {
        return kinopoiskApiClient.findByPageByRating(page, limit, rating);
    }

    @Operation(summary = "Поиск фильмов с указанным жанром")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Список фильмов",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Movie.class))})
    })

    @GetMapping("/genre")
    public List<Movie> getByPageByGenre(
            @Parameter(description = "Страница выборки") @RequestParam(value = "page", required = false, defaultValue = "1") int page,
            @Parameter(description = "Количество элементов на странице") @RequestParam(value = "limit", required = false, defaultValue = "10") int limit,
            @Parameter(description = "Жанр фильма") @RequestParam(value = "genres.name") String genre
    ) {
        return kinopoiskApiClient.findByPageByGenre(page, limit, genre);
    }


}
