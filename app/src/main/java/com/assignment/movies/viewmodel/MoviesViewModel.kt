package com.assignment.movies.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.assignment.movies.database.data.getInitialData
import com.assignment.movies.database.db.MoviesDatabase
import com.assignment.movies.database.entities.Movies
import com.assignment.movies.database.repository.MoviesRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

/**
 * The movies view model that seats between the database and the UI
 */
class MoviesViewModel(application: Application): AndroidViewModel(application) {
    private val repository: MoviesRepository

    init {
        val moviesDao = MoviesDatabase.getDatabase(application).moviesDao()
        repository = MoviesRepository(moviesDao)
    }

    fun saveMovies(movie: Movies): Job{
        return viewModelScope.launch(Dispatchers.IO){
            repository.insertMovies(listOf(movie))
        }
    }

    fun initializeData(): Job{
        return viewModelScope.launch(Dispatchers.IO){
            repository.insertMovies(getInitialData())
        }
    }

    suspend fun getMoviesWithActorName(actor:String): List<Movies>{
        return repository.findMovieByActor(actor)
    }
}