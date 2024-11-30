package com.example.tp5v1.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.tp5v1.databinding.ItemMovieBinding;
import com.example.tp5v1.listener.MovieClickedListener;
import com.example.tp5v1.model.Movie;

import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ViewHolder> {
    private List<Movie> movies;
    private MovieClickedListener movieClickedListener;
    private Context context;

    public MovieAdapter(List<Movie> movies, MovieClickedListener movieClickedListener, Context context) {
        this.movies = movies;
        this.movieClickedListener = movieClickedListener;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemMovieBinding binding=ItemMovieBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Movie movie=movies.get(position);
        holder.bind(movie);

    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private final ItemMovieBinding binding;

        public ViewHolder(@NonNull ItemMovieBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        //metodo para enlazar datos con las vistas
        public void bind(Movie movie){
            binding.movieTitle.setText(movie.getTitle());
            Glide.with(context)
                    .load(movie.getCover())
                    .into(binding.movieImage);
            binding.movieRating.setRating(movie.getStars());
            binding.movieImage.setOnClickListener(v->movieClickedListener.onMovieClicked(movie));
        }
    }
}


