package com.example.tp5obligatorio.view;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tp5obligatorio.R;
import com.example.tp5obligatorio.databinding.ItemArticuloBinding;
import com.example.tp5obligatorio.listener.ArticuloClickedListener;
import com.example.tp5obligatorio.model.Articulo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ArticuloAdapter extends RecyclerView.Adapter<ArticuloAdapter.ViewHolder> {
    private List<Articulo> articulos;
    private ArticuloClickedListener listener;
    private Context context;

    static final Map<String, Integer> COLOR_MAP = new HashMap<>();
    static {
        COLOR_MAP.put("Verde", Color.GREEN);
        COLOR_MAP.put("Azul", Color.BLUE);
        COLOR_MAP.put("Negro", Color.BLACK);
        COLOR_MAP.put("Blanco", Color.WHITE);
        COLOR_MAP.put("Rojo", Color.RED);
        COLOR_MAP.put("Amarillo", Color.YELLOW);
        COLOR_MAP.put("Gris", Color.GRAY);
        COLOR_MAP.put("Celeste", Color.CYAN);
        COLOR_MAP.put("Rosa", Color.MAGENTA);
        COLOR_MAP.put("Estampado", Color.DKGRAY);
    }

    public ArticuloAdapter(List<Articulo> articulos, Context context) {
        this.articulos = articulos;
        this.listener = listener;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemArticuloBinding binding = ItemArticuloBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Articulo articulo = articulos.get(position);
        holder.bind(articulo);
    }

    @Override
    public int getItemCount() {
        return articulos.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private final ItemArticuloBinding binding;

        public ViewHolder(@NonNull ItemArticuloBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(Articulo articulo) {
            binding.nombreArticulo.setText(articulo.getNombre());
            binding.precioArticulo.setText(String.format("$%.2f", articulo.getPrecio()));
            binding.imagenArticulo.setImageResource(articulo.getImagenResourceId());

            binding.getRoot().setOnClickListener(v -> {
                Intent intent = new Intent(context, DetalleArticuloActivity.class);
                intent.putExtra("articulo", articulo);
                context.startActivity(intent);
            });
            // Implementa los círculos de colores
            binding.coloresDisponibles.removeAllViews();
            for (String color : articulo.getColores()) {
                View colorView = new View(context);
                int size = 30;
                int sizepx = (int) (size * context.getResources().getDisplayMetrics().density);
                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(sizepx, sizepx);
                params.setMargins(0, 0, sizepx/3, 0);
                colorView.setLayoutParams(params);

                // Establece el fondo circular
                colorView.setBackground(context.getDrawable(R.drawable.circle_shape));

                // Establece el color
                int colorValue = COLOR_MAP.getOrDefault(color, Color.GRAY);
                colorView.getBackground().setTint(colorValue);

                binding.coloresDisponibles.addView(colorView);
            }
        }
    }
}

