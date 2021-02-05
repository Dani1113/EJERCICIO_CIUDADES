package com.example.ejercicio_ciudades.Controladores;

import com.example.ejercicio_ciudades.Clases.Ciudad;
import com.example.ejercicio_ciudades.Clases.Provincia;
import com.example.ejercicio_ciudades.Tareas.TareaObtenerCiudad;
import com.example.ejercicio_ciudades.Tareas.TareaObtenerProvincia;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

public class CiudadesController {
    public static ArrayList<Ciudad> obtenerCiudades() {
        ArrayList<Ciudad> ciudadesDevueltas = null;
        FutureTask t = new FutureTask (new TareaObtenerCiudad());
        ExecutorService es = Executors.newSingleThreadExecutor();
        es.submit(t);
        try {
            ciudadesDevueltas= (ArrayList<Ciudad>)t.get();
            es.shutdown();
            try {
                if (!es.awaitTermination(800, TimeUnit.MILLISECONDS)) {
                    es.shutdownNow();
                }
            } catch (InterruptedException e) {
                es.shutdownNow();
            }
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return ciudadesDevueltas;
    }
}
