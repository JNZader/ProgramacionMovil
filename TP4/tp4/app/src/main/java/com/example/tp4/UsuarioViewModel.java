package com.example.tp4;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

public class UsuarioViewModel extends ViewModel {
    private MutableLiveData<List<Usuario>>listaUsuariosLV;
    private List<Usuario>usuarios;

    public LiveData<List<Usuario>>getUserList(){
        if (listaUsuariosLV==null){
            listaUsuariosLV=new MutableLiveData<>();
            usuarios=new ArrayList<>();
        }

        return listaUsuariosLV;
    }

    public void addUser(Usuario usuario){
        usuarios.add(usuario);
        listaUsuariosLV.setValue(usuarios);
    }
}
