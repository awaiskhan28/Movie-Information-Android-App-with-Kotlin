package com.assignment.movies

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.assignment.movies.viewmodel.MoviesViewModel

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    fun populateDatabase(view: View){
        val viewModel = MoviesViewModel(application)
        viewModel.initializeData()
        Toast.makeText(this.applicationContext, "Data added successfully.", Toast.LENGTH_LONG)
            .show()
    }

    fun openSearchScreen(view: View){
        Intent(this,SearchMovieActivity::class.java).also {
            startActivity(it)
        }
    }

    fun searchActorScreen(view: View){
        Intent(this,SearchActorsActivity::class.java).also {
            startActivity(it)
        }
    }

    fun searchByTitleFromWebService(view: View){
        Intent(this,WebServiceSearchActivity::class.java).also {
            startActivity(it)
        }
    }
}