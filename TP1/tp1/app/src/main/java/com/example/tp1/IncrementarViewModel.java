package com.example.tp1;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class IncrementarViewModel extends ViewModel {
    private final MutableLiveData<Integer> contador = new MutableLiveData<>(0);

    public LiveData<Integer> getContador() {
        return contador;
    }

    public void incrementar() {
        if (contador.getValue() != null) {
            int nuevoValor = Incrementar.incrementar(contador.getValue());
            contador.setValue(nuevoValor);
        }
    }

}
