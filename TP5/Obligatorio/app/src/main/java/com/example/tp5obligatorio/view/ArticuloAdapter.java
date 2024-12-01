package com.example.tp5obligatorio.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tp5obligatorio.databinding.ItemArticuloBinding;
import com.example.tp5obligatorio.listener.ArticuloClickedListener;
import com.example.tp5obligatorio.model.Articulo;

import java.util.List;

public class ArticuloAdapter extends RecyclerView.Adapter<ArticuloAdapter.ViewHolder> {
    private List<Articulo> articulos;
    private ArticuloClickedListener listener;
    private Context context;

    public ArticuloAdapter(List<Articulo> articulos, ArticuloClickedListener listener, Context context) {
        this.articulos = articulos;
        this.listener = listener;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemArticuloBinding binding=ItemArticuloBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Articulo articulo=articulos.get(position);
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
            binding.precioArticulo.setText(String.valueOf(articulo.getPrecio()));
            binding.imagenArticulo.setImageResource(articulo.getImagenResourceId());
            binding.getRoot().setOnClickListener(v -> listener.onArticuloClicked(articulo));
        }
    }
}
