package com.example.tp5obligatorio.model;

import java.io.Serializable;
import java.util.List;

public class Articulo implements Serializable {
    private String nombre;
    private String genero;
    private List<String> talles;
    private List<String> colores;
    private double precio;
    private String marca;
    private int cantidadDisponible;
    private int imagenResourceId;

    public Articulo(String nombre, String genero, List<String> talles, List<String> colores, double precio, String marca, int cantidadDisponible, int imagenResourceId) {
        this.nombre = nombre;
        this.genero = genero;
        this.talles = talles;
        this.colores = colores;
        this.precio = precio;
        this.marca = marca;
        this.cantidadDisponible = cantidadDisponible;
        this.imagenResourceId = imagenResourceId;
    }

    public Articulo() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public List<String> getTalles() {
        return talles;
    }

    public void setTalles(List<String> talles) {
        this.talles = talles;
    }

    public List<String> getColores() {
        return colores;
    }

    public void setColores(List<String> colores) {
        this.colores = colores;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getCantidadDisponible() {
        return cantidadDisponible;
    }

    public void setCantidadDisponible(int cantidadDisponible) {
        this.cantidadDisponible = cantidadDisponible;
    }

    public int getImagenResourceId() {
        return imagenResourceId;
    }

    public void setImagenResourceId(int imagenResourceId) {
        this.imagenResourceId = imagenResourceId;
    }
}
