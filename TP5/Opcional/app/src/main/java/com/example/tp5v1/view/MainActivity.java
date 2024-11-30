package com.example.tp5v1.view;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;

import com.example.tp5v1.databinding.ActivityMainBinding;
import com.example.tp5v1.listener.MovieClickedListener;
import com.example.tp5v1.model.Movie;
import com.example.tp5v1.viewModel.MoviesViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private MoviesViewModel moviesViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //inicializar el viewmodel con un provider
        moviesViewModel=new ViewModelProvider(this).get(MoviesViewModel.class);

        //configurar el recyclerview
        binding.recyclerView.setLayoutManager(new GridLayoutManager(this,2));

        //observar los cambios en la lista de peliculas
        moviesViewModel.getMoviesList().observe(this, new Observer<List<Movie>>() {
            @Override
            public void onChanged(List<Movie> movies) {
                if (movies!=null&&!movies.isEmpty()){
                    Log.d("moviesList","Mi lista: "+movies.size() );
                    //configurar el adaptador del recyclerview
                    MovieAdapter adapter=new MovieAdapter(movies, new MovieClickedListener() {
                        @Override
                        public void onMovieClicked(Movie movie) {
                            Toast.makeText(MainActivity.this, "Eliges: "+movie.getTitle(), Toast.LENGTH_SHORT).show();
                        }
                    },MainActivity.this);
                    binding.recyclerView.setAdapter(adapter);
                }else {
                    Log.d("moviesList","Lista vacia");
                }
            }
        });

    }
}