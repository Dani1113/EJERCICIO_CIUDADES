package com.example.ejercicio_ciudades.Clases;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.io.Serializable;
import java.util.Objects;

public class Provincia implements Serializable {
    //ATRIBUTOS
    private int idprovincia ;
    private String nombre;

    //CONSTRUCTORES
    public Provincia(String nombre) {
        this.nombre = nombre;
    }

    public Provincia(int idprovincia, String nombre) {
        this.idprovincia = idprovincia;
        this.nombre = nombre;
    }

    //HASH CODE & EQUALS
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Provincia provincia = (Provincia) o;
        return idprovincia == provincia.idprovincia;
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public int hashCode() {
        return Objects.hash(idprovincia);
    }

    //GETTERS & SETTERS
    public int getIdprovincia() {
        return idprovincia;
    }
    public void setIdprovincia(int idprovincia) {
        this.idprovincia = idprovincia;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    //TO STRING
    @Override
    public String toString() {
        return "Nombre provincia " +  nombre;
    }
}