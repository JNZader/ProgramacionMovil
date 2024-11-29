package com.example.tp4;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.tp4.databinding.ActivityMainBinding;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private UsuarioViewModel usuarioViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        usuarioViewModel = new ViewModelProvider(this).get(UsuarioViewModel.class);

        tarea();
    }

    public void tarea() {
        binding.buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nombre = binding.editTextName.getText().toString();
                int edad;

                if (nombre.isEmpty() && binding.editTextAge.getText().toString().isEmpty()) {
                    binding.textViewUserList.setText("ERROR");
                } else {
                    try {
                        edad = Integer.parseInt(binding.editTextAge.getText().toString());
                        Usuario usuario = new Usuario(nombre, edad);
                        usuarioViewModel.addUser(usuario);
                        binding.editTextName.setText("");
                        binding.editTextAge.setText("");
                    } catch (NumberFormatException e) {
                        binding.textViewUserList.setText("Error en el formato de la edad");
                    }
                }
                binding.editTextName.setText("");
                binding.editTextAge.setText("");
            }
        });

        final Observer<List<Usuario>> listaObservada=new Observer<List<Usuario>>() {
            @Override
            public void onChanged(List<Usuario> usuarios) {
                String texto="";
                for(Usuario u: usuarios){
                    texto+=u.toString()+"\n";
                }
                binding.textViewUserList.setText(texto);
            }
        };

        usuarioViewModel.getUserList().observe(this,listaObservada);
    }
}