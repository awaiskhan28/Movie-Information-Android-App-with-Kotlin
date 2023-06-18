package com.assignment.movies

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View.*
import android.widget.*
import androidx.lifecycle.lifecycleScope
import com.assignment.movies.adapters.SearchByActorsAdapter
import com.assignment.movies.database.entities.Movies
import com.assignment.movies.viewmodel.MoviesViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class SearchActorsActivity : AppCompatActivity() {

    private lateinit var listView: ListView
    private lateinit var search: Button
    private lateinit var searchText: EditText
    private lateinit var loading: LinearLayout
    private lateinit var noResultsView: TextView

    private lateinit var adapter: SearchByActorsAdapter

    private var searchResults:MutableList<Movies> = emptyList<Movies>().toMutableList()
    private var currentSearchText :String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_actors)

        listView = findViewById(R.id.list_view)
        search = findViewById(R.id.btn_search_by_actor)
        searchText = findViewById(R.id.txt_search_db_text)
        loading = findViewById(R.id.loading_layout_db)
        noResultsView = findViewById(R.id.txt_no_result)

        if(savedInstanceState != null){
            val array = savedInstanceState.get("search-result") as ArrayList<Movies>
            searchResults = array.toMutableList()
            adapter = SearchByActorsAdapter(this,searchResults)
            listView.adapter = adapter

            searchText.setText(savedInstanceState.getString("search-text"))
        }

        loading.visibility = INVISIBLE

        /**
         * Performs the search and updates UI components
         */
        search.setOnClickListener {
            lifecycleScope.launch {
                loading.visibility = VISIBLE
                searchByActor(searchText.text.trim().toString())
                loading.visibility = INVISIBLE

                if(searchResults.isEmpty()){
                    noResultsView.visibility = VISIBLE
                }else{
                    noResultsView.visibility = GONE
                    adapter = SearchByActorsAdapter(it.context as Activity,searchResults)
                    listView.adapter = adapter
                }
            }
        }
    }

    /**
     * Preserves application state on rotation
     */
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putParcelableArrayList("search-result", ArrayList<Movies>(searchResults))
        outState.putString("search-text", currentSearchText)
    }

    /**
     *Performs the search asynchronously
     */
    private suspend fun searchByActor(text: String){
        if (text.isNotEmpty()){
            withContext(Dispatchers.IO){
                val viewModel = MoviesViewModel(application)
                val queryResults = viewModel.getMoviesWithActorName(text)
                searchResults = queryResults as MutableList<Movies>
            }
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }
}