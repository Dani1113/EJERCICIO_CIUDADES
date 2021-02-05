package com.example.ejercicio_ciudades.Tareas;

import com.example.ejercicio_ciudades.Clases.Ciudad;
import com.example.ejercicio_ciudades.Modelos.CiudadDB;

import java.util.ArrayList;
import java.util.concurrent.Callable;

public class TareaObtenerCiudad implements Callable<ArrayList<Ciudad>> {

    @Override
    public ArrayList<Ciudad> call() throws Exception {
        ArrayList<Ciudad> ciudades = CiudadDB.obtenerCiudades();
        return ciudades;
    }
}