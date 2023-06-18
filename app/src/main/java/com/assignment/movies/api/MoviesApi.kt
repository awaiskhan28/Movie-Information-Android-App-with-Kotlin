package com.assignment.movies.api

import com.assignment.movies.database.entities.Movies
import org.json.JSONObject
import java.io.BufferedInputStream
import java.net.HttpURLConnection
import java.net.URL

class MoviesApi {

    companion object{

        /**
         * Get movies by title
         */
        fun searchForMovieByTitle(request: URL) : Movies{
            val urlConnection = request.openConnection() as HttpURLConnection
            val response = BufferedInputStream(urlConnection.inputStream)
            val jsonResponse = JSONObject(String(response.readBytes()))
            urlConnection.disconnect()

            return convertToMovieObject(jsonResponse)
        }

        /**
         * Get movies by title
         */
        fun searchForMovieByTitleGeneral(request: URL) : List<Movies>{
            val urlConnection = request.openConnection() as HttpURLConnection
            val response = BufferedInputStream(urlConnection.inputStream)
            val jsonResponse = JSONObject(String(response.readBytes()))
            urlConnection.disconnect()

            return convertToMovieList(jsonResponse)
        }


        /**
         * Converts the json string to a Movies Object
         */
        private fun convertToMovieObject(jsonObject: JSONObject): Movies{
            return if (jsonObject.has("Title")){
                Movies(
                    null,
                    jsonObject.getString("Title"),
                    jsonObject.getString("Year"),
                    jsonObject.getString("Rated"),
                    jsonObject.getString("Released"),
                    jsonObject.getString("Runtime"),
                    jsonObject.getString("Genre"),
                    jsonObject.getString("Director"),
                    jsonObject.getString("Writer"),
                    jsonObject.getString("Actors"),
                    jsonObject.getString("Plot")
                )

            }else{
                Movies(null,"No Movie with the specified title","-1",null,"","","","","","",
                "")
            }
        }


        /**
         * Converts the json string to a Movies List
         */
        private fun convertToMovieList(jsonObject: JSONObject): List<Movies>{
            return if (jsonObject.has("Search")){
                val movieList: MutableList<Movies> = emptyList<Movies>().toMutableList()
                val jsonArray = jsonObject.getJSONArray("Search")

                for (i in 0 until jsonArray.length()){
                    val movieObject = jsonArray.getJSONObject(i)
                    movieList.add(
                        Movies(
                            null,
                            movieObject.getString("Title"),
                            movieObject.getString("Year"),
                            "",
                            "",
                            "",
                            "",
                            "",
                            "",
                            "",
                            ""
                        )
                    )
                }

                movieList
            }else{
                emptyList()
            }
        }


    }


}