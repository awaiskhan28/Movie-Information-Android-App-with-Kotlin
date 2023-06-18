package com.assignment.movies.database.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.assignment.movies.database.dao.MoviesDao
import com.assignment.movies.database.entities.Movies

/**
 * The database object that creates and manages the Room instance
 */
@Database(entities = [Movies::class],version = 3)
abstract  class MoviesDatabase: RoomDatabase() {
    abstract fun moviesDao(): MoviesDao

    companion object{

        @Volatile
        private var DB_INSTANCE: MoviesDatabase? = null

        fun getDatabase(context: Context): MoviesDatabase{
            val temp = DB_INSTANCE
            if(temp != null){
                return temp
            }

            synchronized(this){
                val newInstance = Room.databaseBuilder(
                    context.applicationContext,
                    MoviesDatabase::class.java,"movies_database"
                )
                    .fallbackToDestructiveMigration()
                    .build()

                DB_INSTANCE = newInstance
                return newInstance
            }
        }
    }
}