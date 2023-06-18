package com.assignment.movies

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View.INVISIBLE
import android.view.View.VISIBLE
import android.widget.*
import androidx.lifecycle.lifecycleScope
import com.assignment.movies.database.entities.Movies
import com.assignment.movies.viewmodel.MoviesViewModel
import com.assignment.movies.api.MoviesService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class SearchMovieActivity : AppCompatActivity() {

    private lateinit var btnRetrieve: Button
    private lateinit var btnSave: Button
    private lateinit var txtSearch: EditText
    private lateinit var txtResult: TextView
    private lateinit var loadingLayout: LinearLayout

    private var searchResult: String? = null
    private var movie: Movies? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_movie)

        if(savedInstanceState != null){
            searchResult = savedInstanceState.get("search-result") as String?
            txtResult.text = searchResult?: ""

            txtSearch.setText(savedInstanceState.getString("search-text" as String?))
        }

        btnRetrieve = findViewById(R.id.btn_retrieve)
        btnSave = findViewById(R.id.btn_save_movie)
        txtSearch = findViewById(R.id.txt_search_text)
        txtResult = findViewById(R.id.txt_search_results)
        loadingLayout = findViewById(R.id.loading_layout)

        loadingLayout.visibility = INVISIBLE

        btnRetrieve.setOnClickListener {
            lifecycleScope.launch {
                loadingLayout.visibility = VISIBLE
                enableButtons(false)

                searchForMovie(txtSearch.text.toString())

                enableButtons(true)
                loadingLayout.visibility = INVISIBLE
                txtResult.text = searchResult
            }
        }


        btnSave.setOnClickListener {
            val viewModel = MoviesViewModel(application)
             movie?.let { m ->
                 viewModel.saveMovies(m)
                 Toast.makeText(this.applicationContext, "Movie added successfully", Toast.LENGTH_LONG)
                     .show()
            }

        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString("search-result",searchResult)
        outState.putString("search-text",txtSearch.text.toString())
    }

    /**
     * Gets a movie base on the text String
     */
    private suspend fun searchForMovie(text: String){
        if (text.isNotEmpty()){
            withContext(Dispatchers.IO){
                val movieSearchResult = MoviesService().searchMovieByTitle(txtSearch.text.toString())
                searchResult = if(movieSearchResult.year == "-1"){
                    movieSearchResult.title
                }else{
                    movie = movieSearchResult
                    buildMovieInfo(movieSearchResult)
                }
            }
        }
    }

    /**
     * Enables/Disable the buttons
     */
    private fun enableButtons(enable: Boolean){
        btnRetrieve.isEnabled = enable
        btnSave.isEnabled = enable
    }

    /**
     * Converts the movie object to a string
     */
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