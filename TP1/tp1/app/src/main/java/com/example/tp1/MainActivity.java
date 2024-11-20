package com.example.tp1;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.ViewModelProvider;

import com.example.tp1.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private IncrementarViewModel incrementarViewModel;
    private int res=0;
    private static final String TAG = "TAG1";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        //inicializamos el viewmodel
        incrementarViewModel=new ViewModelProvider(this).get(IncrementarViewModel.class);
        Log.d("TAG1","onCreate()");
        //mostrar el valor de  los editText ya que este metodo se eejecutara varias veces
        binding.tvResCon.setText("Con ViewModel: "+incrementarViewModel.getContador().getValue());
        binding.tvResSin.setText("Sin ViewModel: "+res);
        tarea();
    }

    public void tarea(){
        binding.btnResSin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //actualizar variable local
                res=Incrementar.incrementar(res);
                binding.tvResSin.setText("Sin ViewModel: "+res);
            }
        });

        binding.btnResCon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //incrementar el valor almacenado en el viewmodel
                incrementarViewModel.incrementar();
                binding.tvResCon.setText("Con ViewModel: "+incrementarViewModel.getContador().getValue());
            }
        });
    }
    
    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart llamado");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume llamado");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause llamado");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop llamado");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy llamado");
    }
}