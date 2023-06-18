package com.assignment.movies.api

import com.assignment.movies.database.entities.Movies
import java.net.URL

class MoviesService{

    private val baseUrl: String = "http://www.omdbapi.com/?apikey=7ec39f6c"

    /**
     * Gets movies by title
     */
    fun searchMovieByTitle(title:String): Movies{
        val searchUrl = "${baseUrl}&t=${title}"
        val url = URL(searchUrl)
        return MoviesApi.searchForMovieByTitle(url)
    }

    fun searchMovieByTitleGeneral(title:String): List<Movies>{
        val searchUrl = "${baseUrl}&s=${title}"
        val url = URL(searchUrl)
        return MoviesApi.searchForMovieByTitleGeneral(url)
    }

}