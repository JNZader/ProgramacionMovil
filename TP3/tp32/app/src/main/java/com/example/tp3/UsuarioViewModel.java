package com.example.tp3;

import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

public class UsuarioViewModel extends ViewModel {
    private List<Usuario> usuarios=new ArrayList<>();

    public List<Usuario> getUsuarios(){
        return usuarios;
    }

    public void addUsuario(Usuario usuario){
        usuarios.add(usuario);
    }
}
