package com.example.tp5obligatorio.view;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;

import com.example.tp5obligatorio.R;
import com.example.tp5obligatorio.databinding.ActivityMainBinding;

import viewModel.ArticuloViewModel;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private ArticuloViewModel articuloViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        articuloViewModel = new ViewModelProvider(this).get(ArticuloViewModel.class);

        binding.recyclerView.setLayoutManager(new GridLayoutManager(this, 2));

        articuloViewModel.getArticulosList().observe(this, articulos -> {
            ArticuloAdapter adapter = new ArticuloAdapter(articulos, this);
            binding.recyclerView.setAdapter(adapter);
        });

    }
}