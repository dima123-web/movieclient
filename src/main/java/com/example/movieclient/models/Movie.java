package com.example.movieclient.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Movie {

    private Long id;

    private String name;

    private String type;

    private Integer year;

    private String description;

    private String shortDescription;

    private String slogan;

    private Integer movieLength;

    private Integer ageRating;

    private Float ratingKp;

    private Float ratingImdb;

    private Float ratingFilmCritics;

    private String posterUrl;

    private List<String> countries;

    private List<String> genres;
}

