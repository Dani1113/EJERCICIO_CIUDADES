package com.example.ejercicio_ciudades.Tareas;

import com.example.ejercicio_ciudades.Clases.Provincia;
import com.example.ejercicio_ciudades.Modelos.ProvinciaDB;

import java.util.concurrent.Callable;

public class TareaBorrarProvincia implements Callable<Boolean> {
    private Provincia p = null;

    public TareaBorrarProvincia(Provincia p) {
        this.p = p;
    }

    @Override
    public Boolean call() throws Exception {
        boolean borradoOk = ProvinciaDB.borrarProvincia(p);
        return borradoOk;
    }
}
