package com.example.tp5v1.viewModel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.tp5v1.model.Movie;

import java.util.ArrayList;
import java.util.List;

public class MoviesViewModel extends ViewModel {
    private MutableLiveData<List<Movie>> moviesList;

    public MoviesViewModel(){
        moviesList=new MutableLiveData<>();
        loadMovies();
    }

    private void loadMovies(){
        List<Movie> movies=new ArrayList<>();
        movies.add(new Movie("Vacaciones en familia","https://via.assets.so/movie.png?id=1",3.0f));
        movies.add(new Movie("He's all that","https://via.assets.so/movie.png?id=2",4.0f));
        movies.add(new Movie("Venom","https://via.assets.so/movie.png?id=3",2.5f));
        movies.add(new Movie("Encanto","https://via.assets.so/movie.png?id=4",4.0f));
        movies.add(new Movie("Los locos adams","https://via.assets.so/movie.png?id=5",4.0f));
        movies.add(new Movie("LAMB","https://via.assets.so/movie.png?id=6",2.0f));
    }
}