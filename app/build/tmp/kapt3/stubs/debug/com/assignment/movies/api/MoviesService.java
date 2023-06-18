package com.assignment.movies.api;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0004J\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00060\t2\u0006\u0010\u0007\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D\u00a2\u0006\u0002\n\u0000\u00a8\u0006\n"}, d2 = {"Lcom/assignment/movies/api/MoviesService;", "", "()V", "baseUrl", "", "searchMovieByTitle", "Lcom/assignment/movies/database/entities/Movies;", "title", "searchMovieByTitleGeneral", "", "app_debug"})
public final class MoviesService {
    private final java.lang.String baseUrl = "http://www.omdbapi.com/?apikey=7ec39f6c";
    
    public MoviesService() {
        super();
    }
    
    /**
     * Gets movies by title
     */
    @org.jetbrains.annotations.NotNull()
    public final com.assignment.movies.database.entities.Movies searchMovieByTitle(@org.jetbrains.annotations.NotNull()
    java.lang.String title) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.assignment.movies.database.entities.Movies> searchMovieByTitleGeneral(@org.jetbrains.annotations.NotNull()
    java.lang.String title) {
        return null;
    }
}