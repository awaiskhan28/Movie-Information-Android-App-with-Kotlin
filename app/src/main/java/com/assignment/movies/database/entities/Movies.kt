package com.assignment.movies.database.entities

import android.os.Parcel
import android.os.Parcelable
import androidx.room.*
import kotlinx.parcelize.Parceler
import kotlinx.parcelize.Parcelize


/**
 * The Movies entity from which the movies table is created.
 * It is parcelized to allow for bundling in order to maintain the application state
 */
@Parcelize
@Entity(tableName = "movies",indices = [Index(value = ["title"],unique = true)])
data class Movies (

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "rowid")
    val id: Int?,

    val title: String,
    val year: String,
    val rated: String?,
    val released: String,
    val runTIme: String,
    val genre: String,
    val director: String,
    val writer: String,
    val actors: String,
    val plot: String
): Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readString()?: "",
        parcel.readString()?: "",
        parcel.readString(),
        parcel.readString()?: "",
        parcel.readString()?: "",
        parcel.readString()?: "",
        parcel.readString()?: "",
        parcel.readString()?: "",
        parcel.readString()?: "",
        parcel.readString()?: ""
    ) {
    }

    companion object : Parceler<Movies> {

        override fun Movies.write(parcel: Parcel, flags: Int) {
            parcel.writeValue(id)
            parcel.writeString(title)
            parcel.writeString(year)
            parcel.writeString(rated)
            parcel.writeString(released)
            parcel.writeString(runTIme)
            parcel.writeString(genre)
            parcel.writeString(director)
            parcel.writeString(writer)
            parcel.writeString(actors)
            parcel.writeString(plot)
        }

        override fun create(parcel: Parcel): Movies {
            return Movies(parcel)
        }
    }
}