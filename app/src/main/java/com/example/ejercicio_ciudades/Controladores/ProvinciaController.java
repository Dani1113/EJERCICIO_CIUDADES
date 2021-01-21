package com.example.ejercicio_ciudades.Controladores;

import com.example.ejercicio_ciudades.Clases.Provincia;
import com.example.ejercicio_ciudades.Tareas.TareaActualizarProvincia;
import com.example.ejercicio_ciudades.Tareas.TareaBorrarProvincia;
import com.example.ejercicio_ciudades.Tareas.TareaInsertarProvincia;
import com.example.ejercicio_ciudades.Tareas.TareaObtenerProvincia;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

public class ProvinciaController {
    public static boolean insertarProvincia(Provincia p){
        FutureTask t = new FutureTask(new TareaInsertarProvincia(p));
        ExecutorService es = Executors.newSingleThreadExecutor();
        es.submit(t);
        boolean inserciónOK = false;
        try {
            inserciónOK = (boolean) t.get();
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
        finally {
            return inserciónOK;
        }
    }

    public static ArrayList<Provincia> obtenerProvincias() {
        ArrayList<Provincia> provinciasDevueltas = null;
        FutureTask t = new FutureTask (new TareaObtenerProvincia());
        ExecutorService es = Executors.newSingleThreadExecutor();
        es.submit(t);
        try {
            provinciasDevueltas= (ArrayList<Provincia>)t.get();
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
        return provinciasDevueltas;
    }

    public static boolean borrarProvincia(Provincia p) {
        FutureTask t = new FutureTask(new TareaBorrarProvincia(p));
        ExecutorService es = Executors.newSingleThreadExecutor();
        es.submit(t);
        boolean borradoOk = false;
        try {
            borradoOk = (boolean) t.get();
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
        finally {
            return borradoOk;
        }
    }

    public static boolean actualizarProvincia(Provincia p) {
        FutureTask t = new FutureTask(new TareaActualizarProvincia(p));
        ExecutorService es = Executors.newSingleThreadExecutor();
        es.submit(t);
        boolean actualizadoOk = false;
        try {
            actualizadoOk = (boolean) t.get();
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
        finally {
            return actualizadoOk;
        }
    }
}