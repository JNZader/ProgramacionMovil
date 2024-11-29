package com.example.tp3;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.example.tp3.databinding.ActivityMainBinding;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private UsuarioViewModel usuarioVM;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        usuarioVM = new ViewModelProvider(this).get(UsuarioViewModel.class);
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
                        usuarioVM.addUsuario(usuario);
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
        binding.buttonShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                List<Usuario> lista = usuarioVM.getUsuarios();
                String texto = "";
                for (Usuario u : lista) {
                    texto += u.toString() + "\n";
                }
                binding.textViewUserList.setText(texto);
            }
        });
    }
}