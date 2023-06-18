package com.assignment.movies.adapters

import android.annotation.SuppressLint
import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.assignment.movies.R
import com.assignment.movies.database.entities.Movies

/**
 * Creates a custom list view items
 */
class SearchByActorsAdapter(private val context: Activity,private val objects: MutableList<Movies>) :
    BaseAdapter() {

    private lateinit var listItem: TextView

    override fun getCount(): Int {
        return objects.size
    }

    override fun getItem(position: Int): Any {
        return objects[position]
    }

    override fun getItemId(position: Int): Long {
        return objects[position].id!!.toLong()
    }

    @SuppressLint("ViewHolder")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val myView  = LayoutInflater.from(context).inflate(R.layout.search_by_actors_list_item,parent,false)
        listItem = myView.findViewById(R.id.list_item)
        listItem.text = buildMovieInfo(objects[position])
        return myView
    }

    private fun buildMovieInfo(movie:Movies): String{
        return """
            Title: ${movie.title}
            Year: ${movie.year}
            Rated: ${movie.rated}
            Released: ${movie.released}
            Runtime: ${movie.runTIme}
            Genre: ${movie.genre}
            Director: ${movie.director}
            Writer: ${movie.writer}
            Actors: ${movie.actors}
            Plot: ${movie.plot}
        """.trimIndent()
    }

}