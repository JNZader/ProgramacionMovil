package com.example.tp2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.tp2.databinding.ActivitySegundaBinding;

public class SegundaActivity extends AppCompatActivity {
    private ActivitySegundaBinding binding;
    private TraductorViewModel traductorViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding=ActivitySegundaBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        traductorViewModel=new ViewModelProvider(this).get(TraductorViewModel.class);

        String palSpa=getIntent().getStringExtra("PalabraEsp");

        if (palSpa!=null){
            traductorViewModel.traducirPalabra(palSpa);
        }

        traductorViewModel.getImagen().observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer imagen) {
                binding.ivImagen.setImageResource(imagen);
            }
        });

        traductorViewModel.getPalabraTraducida().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String palabraTraducida) {
                binding.etIngles.setText(palabraTraducida);
            }
        });

        binding.btnVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(SegundaActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}