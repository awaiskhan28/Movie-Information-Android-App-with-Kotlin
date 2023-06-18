package com.assignment.movies

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.lifecycle.lifecycleScope
import com.assignment.movies.adapters.SearchByActorsAdapter
import com.assignment.movies.api.MoviesService
import com.assignment.movies.database.entities.Movies
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class WebServiceSearchActivity : AppCompatActivity() {

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
        setContentView(R.layout.activity_web_service_search)

        listView = findViewById(R.id.list_view_web)
        search = findViewById(R.id.btn_search_web)
        searchText = findViewById(R.id.txt_search_web_text)
        loading = findViewById(R.id.loading_layout_web)
        noResultsView = findViewById(R.id.txt_no_result_web)

        if(savedInstanceState != null){
            val array = savedInstanceState.get("search-result") as ArrayList<Movies>
            searchResults = array.toMutableList()
            adapter = SearchByActorsAdapter(this,searchResults)
            listView.adapter = adapter

            searchText.setText(savedInstanceState.getString("search-text"))
        }

        loading.visibility = View.INVISIBLE

        /**
         * Performs the search and updates UI components
         */
        search.setOnClickListener {
            lifecycleScope.launch {
                loading.visibility = View.VISIBLE
                searchWeb(searchText.text.trim().toString())
                loading.visibility = View.INVISIBLE

                if(searchResults.isEmpty()){
                    noResultsView.visibility = View.VISIBLE
                }else{
                    noResultsView.visibility = View.GONE
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
    private suspend fun searchWeb(text: String){
        if (text.isNotEmpty()){
            withContext(Dispatchers.IO){
                val queryResults = MoviesService().searchMovieByTitleGeneral(searchText.text.toString())
                searchResults = queryResults as MutableList<Movies>
            }
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }
}