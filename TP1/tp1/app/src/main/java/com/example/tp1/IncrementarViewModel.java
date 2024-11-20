package com.example.tp1;

import androidx.lifecycle.ViewModel;

public class IncrementarViewModel extends ViewModel {
    private int contador=0;

    public void incrementar(){
        contador=Incrementar.incrementar(contador);
    }

    public int getContador() {
        return contador;
    }
}
