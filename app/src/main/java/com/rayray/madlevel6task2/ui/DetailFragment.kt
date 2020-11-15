package com.rayray.madlevel6task2.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.setFragmentResult
import androidx.fragment.app.setFragmentResultListener
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.rayray.madlevel6task2.R
import com.rayray.madlevel6task2.adapter.MovieAdapter
import com.rayray.madlevel6task2.model.Movie
import kotlinx.android.synthetic.main.fragment_detail.*
import kotlinx.android.synthetic.main.movie_item.view.*

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class DetailFragment : Fragment() {

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeMovieResult()

    }

    private fun observeMovieResult() {
        setFragmentResultListener(REQ_MOVIE_KEY){ key, bundle ->
            bundle.getParcelable<Movie>(BUNDLE_MOVIE_KEY)?.let {
                val movie = Movie(it.backdrop, it.poster, it.title, it.release_date, it.rating,
                it.overview)
                context?.let { it1 -> Glide.with(it1).load(movie.getBackDropImage()).into(ivBackdrop) }
                context?.let { it1 -> Glide.with(it1).load(movie.getPosterImage()).into(ivPoster) }

                tvTitle.text = movie.title
                tvReleaseDate.text = movie.release_date
                tvRating.text = movie.rating.toString()
                tvDescription.text = movie.overview
            }
        }
    }
}