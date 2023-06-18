package com.assignment.movies.api;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0004"}, d2 = {"Lcom/assignment/movies/api/MoviesApi;", "", "()V", "Companion", "app_debug"})
public final class MoviesApi {
    @org.jetbrains.annotations.NotNull()
    public static final com.assignment.movies.api.MoviesApi.Companion Companion = null;
    
    public MoviesApi() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\u0002J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0002J\u000e\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000bJ\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\n\u001a\u00020\u000b\u00a8\u0006\r"}, d2 = {"Lcom/assignment/movies/api/MoviesApi$Companion;", "", "()V", "convertToMovieList", "", "Lcom/assignment/movies/database/entities/Movies;", "jsonObject", "Lorg/json/JSONObject;", "convertToMovieObject", "searchForMovieByTitle", "request", "Ljava/net/URL;", "searchForMovieByTitleGeneral", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        /**
         * Get movies by title
         */
        @org.jetbrains.annotations.NotNull()
        public final com.assignment.movies.database.entities.Movies searchForMovieByTitle(@org.jetbrains.annotations.NotNull()
        java.net.URL request) {
            return null;
        }
        
        /**
         * Get movies by title
         */
        @org.jetbrains.annotations.NotNull()
        public final java.util.List<com.assignment.movies.database.entities.Movies> searchForMovieByTitleGeneral(@org.jetbrains.annotations.NotNull()
        java.net.URL request) {
            return null;
        }
        
        /**
         * Converts the json string to a Movies Object
         */
        private final com.assignment.movies.database.entities.Movies convertToMovieObject(org.json.JSONObject jsonObject) {
            return null;
        }
        
        /**
         * Converts the json string to a Movies List
         */
        private final java.util.List<com.assignment.movies.database.entities.Movies> convertToMovieList(org.json.JSONObject jsonObject) {
            return null;
        }
    }
}