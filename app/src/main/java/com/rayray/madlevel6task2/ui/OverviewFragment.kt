package com.rayray.madlevel6task2.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.core.os.bundleOf
import androidx.fragment.app.setFragmentResult
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.google.android.material.snackbar.Snackbar
import com.rayray.madlevel6task2.R
import com.rayray.madlevel6task2.adapter.MovieAdapter
import com.rayray.madlevel6task2.model.Movie
import com.rayray.madlevel6task2.model.MovieViewModel
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_overview.*

const val REQ_MOVIE_KEY = "req_movie"
const val BUNDLE_MOVIE_KEY = "bundle_movie"


/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class OverviewFragment : Fragment() {

    private lateinit var navController: NavController
    private lateinit var movieAdapter: MovieAdapter
    //private lateinit var viewManager: RecyclerView.LayoutManager

    private var movies = arrayListOf<Movie>()
    private val viewModel: MovieViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_overview, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        movieAdapter = MovieAdapter(movies, ::onMovieClick)
        navController = findNavController()

        submitBtn.setOnClickListener {
            viewModel.getMovies(ilYear.text.toString())
        }

        rvMovies.layoutManager = StaggeredGridLayoutManager(2, LinearLayoutManager.VERTICAL)
        rvMovies.adapter = movieAdapter
        observeMovie()
    }

    private fun observeMovie() {
        viewModel.movie.observe(viewLifecycleOwner, Observer {
            movies.clear()
            movies.addAll(it)
            movieAdapter.notifyDataSetChanged()
        })
    }

    private fun onMovieClick(movie: Movie) {
        setFragmentResult(REQ_MOVIE_KEY, bundleOf(Pair(BUNDLE_MOVIE_KEY, movie)))
        navController.navigate(R.id.action_overviewFragment_to_detailFragment)
    }
}