package com.example.ejercicio_ciudades.Clases;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.io.Serializable;
import java.util.Objects;

public class Ciudad implements Serializable {
    //ATRIBUTOS
    private int idciudad;
    private String nombre;
    private int habitantes;
    private int idprovincia;

    //CONSTRUCTORES
    public Ciudad(int idciudad, String nombre, int habitantes, int idprovincia) {
        this.idciudad = idciudad;
        this.nombre = nombre;
        this.habitantes = habitantes;
        this.idprovincia = idprovincia;
    }

    public Ciudad() {
        this.idciudad = 0;
        this.nombre = "";
        this.habitantes = 0;
        this.idprovincia = 1;
    }

    public Ciudad(String nombre, int habitantes, int idprovincia) {
        this.nombre = nombre;
        this.habitantes = habitantes;
        this.idprovincia = idprovincia;
    }

    //HASH CODE & EQUALS
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ciudad ciudad = (Ciudad) o;
        return idciudad == ciudad.idciudad;
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public int hashCode() {
        return Objects.hash(idciudad);
    }

    //GETTERS & SETTERS
    public int getIdprovincia() {
        return idprovincia;
    }
    public void setIdprovincia(int idprovincia) {
        this.idprovincia = idprovincia;
    }
    public int getIdciudad() {
        return idciudad;
    }
    public void setIdciudad(int idciudad) {
        this.idciudad = idciudad;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public int getHabitantes() {
        return habitantes;
    }
    public void setHabitantes(int habitantes) {
        this.habitantes = habitantes;
    }

    //TO STRING
    @Override
    public String toString() {
        return "Ciudad [idciudad=" + idciudad + ", nombre=" + nombre + ", habitantes=" + habitantes + ", idprovincia=" + idprovincia + "]";
    }
}