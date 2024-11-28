package com.example.tp3;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.example.tp3.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private UsuarioViewModel usuarioVM;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        usuarioVM=new ViewModelProvider(this).get(UsuarioViewModel.class);
    }
}