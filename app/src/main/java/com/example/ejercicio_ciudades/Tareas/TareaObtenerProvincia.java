package com.example.ejercicio_ciudades.Tareas;

import com.example.ejercicio_ciudades.Clases.Provincia;
import com.example.ejercicio_ciudades.Modelos.ProvinciaDB;

import java.util.ArrayList;
import java.util.concurrent.Callable;

public class TareaObtenerProvincia implements Callable <ArrayList<Provincia>> {

    @Override
    public ArrayList<Provincia> call() throws Exception {
        ArrayList<Provincia> provincias = ProvinciaDB.obtenerProvincias();
        return provincias;
    }
}
