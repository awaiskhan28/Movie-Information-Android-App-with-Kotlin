package com.assignment.movies.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.assignment.movies.database.entities.Movies

@Dao
interface MoviesDao {

    @Query("SELECT * FROM movies")
    suspend fun getAll(): List<Movies>

    @Query("SELECT * FROM movies WHERE actors LIKE '%'||:actorName||'%'")
    suspend fun findByActorName(actorName: String): List<Movies>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveMovies(movies: List<Movies>)

}