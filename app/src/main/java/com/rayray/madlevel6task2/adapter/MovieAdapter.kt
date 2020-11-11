package com.rayray.madlevel6task2.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.rayray.madlevel6task2.R
import com.rayray.madlevel6task2.model.Movie
import kotlinx.android.synthetic.main.movie_item.view.*

class MovieAdapter(private val movies: List<Movie>, private val onClick: (Movie) -> Unit) :
    RecyclerView.Adapter<MovieAdapter.ViewHolder>() {

    private lateinit var context: Context

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        init {
            itemView.setOnClickListener{
                onClick(movies[adapterPosition])
            }
        }

        fun bind(movie: Movie) {
            Glide.with(context).load(movie.getPosterImage()).into(itemView.ivMoviePosterItem)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        context = parent.context
        return ViewHolder(
            LayoutInflater.from(context).inflate(R.layout.movie_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: MovieAdapter.ViewHolder, position: Int) {
        holder.bind(movies[position])
    }

    override fun getItemCount(): Int {
        return movies.size
    }
}