package com.example.adonaisgn.pizzeria.modelo.entidad;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Adonais.gn on 06/11/2016.
 */

public class Pedido implements Serializable {
    private String nombre;
    private String direccion;
    private String telefono;
    private String tamaño;
    private ArrayList<String> listaIngredientes;
    private double Precio;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return Precio;
    }

    public void setPrecio(double precio) {
        Precio = precio;
    }

    public ArrayList<String> getListaIngredientes() {
        return listaIngredientes;
    }

    public void setListaIngredientes(ArrayList<String> listaIngredientes) {
        this.listaIngredientes = listaIngredientes;
    }

    public String getTamaño() {
        return tamaño;
    }

    public void setTamaño(String tamaño) {
        this.tamaño = tamaño;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "nombre='" + nombre + '\'' +
                ", direccion='" + direccion + '\'' +
                ", telefono='" + telefono + '\'' +
                ", tamaño='" + tamaño + '\'' +
                ", listaIngredientes=" + listaIngredientes +
                ", Precio=" + Precio +
                '}';
    }

    public String toFichero(){
        return nombre +";" +telefono +";" +direccion +";" +tamaño +";" +listaIngredientes +";" +Precio;
    }

}

