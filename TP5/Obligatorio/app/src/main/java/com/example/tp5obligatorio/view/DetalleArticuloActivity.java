package com.example.tp5obligatorio.view;

import static com.example.tp5obligatorio.view.ArticuloAdapter.*;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.example.tp5obligatorio.R;
import com.example.tp5obligatorio.databinding.DetalleArticuloBinding;
import com.example.tp5obligatorio.model.Articulo;

public class DetalleArticuloActivity extends AppCompatActivity {

    private DetalleArticuloBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DetalleArticuloBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Articulo articulo = (Articulo) getIntent().getSerializableExtra("articulo");

        if (articulo != null) {
            binding.imagenArticulo.setImageResource(articulo.getImagenResourceId());
            binding.nombreArticulo.setText(articulo.getNombre());
            binding.precioArticulo.setText(String.format("Precio: $%.2f", articulo.getPrecio()));
            binding.generoArticulo.setText("Género: " + articulo.getGenero());
            binding.marcaArticulo.setText("Marca: Lewis");
            binding.cantidadDisponible.setText("Cantidad disponible: 20");

            // Mostrar talles disponibles
            StringBuilder talles = new StringBuilder("Talles disponibles: ");
            for (String talle : articulo.getTalles()) {
                talles.append(talle).append(", ");
            }
            binding.tallesDisponibles.setText(talles.substring(0, talles.length() - 2));

            // Mostrar colores disponibles
            binding.coloresDisponibles.removeAllViews();
            for (String color : articulo.getColores()) {
                View colorView = new View(this);
                int size = 40;
                int sizepx = (int) (size * getResources().getDisplayMetrics().density);
                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(sizepx, sizepx);
                params.setMargins(0, 0, sizepx/3, 0);
                colorView.setLayoutParams(params);

                colorView.setBackground(getDrawable(R.drawable.circle_shape));

                int colorValue = ArticuloAdapter.COLOR_MAP.getOrDefault(color, Color.GRAY);
                colorView.getBackground().setTint(colorValue);

                binding.coloresDisponibles.addView(colorView);
            }
        }
    }
}
