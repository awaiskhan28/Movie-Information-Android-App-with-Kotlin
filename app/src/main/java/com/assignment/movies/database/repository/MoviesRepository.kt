package com.assignment.movies.database.repository

import com.assignment.movies.database.dao.MoviesDao
import com.assignment.movies.database.entities.Movies

/**
 * Interacts with the dao to fetch the data
 */
class MoviesRepository(private val moviesDao: MoviesDao) {

    suspend fun insertMovies(movies: List<Movies>) = moviesDao.saveMovies(movies)

    suspend fun findMovieByActor(actorName: String) =  moviesDao.findByActorName(actorName)

}