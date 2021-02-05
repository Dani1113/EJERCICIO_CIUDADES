package com.example.ejercicio_ciudades;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.ejercicio_ciudades.Clases.Ciudad;
import com.example.ejercicio_ciudades.Controladores.CiudadesController;

import java.util.ArrayList;

public class MostrarCiudadesActivity extends AppCompatActivity {

    private RecyclerView rwCiudades = null;
    private ArrayList<Ciudad> ciudades = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_ciudades);
        rwCiudades = (RecyclerView) findViewById(R.id.rwCiudades);
        ciudades = CiudadesController.obtenerCiudades();
        if(ciudades != null){
            for (Ciudad c: ciudades) {
                Log.i("Ciudades", c.toString());
            }
        }else{
            Log.i("Ciudades", "No pude recuperar las ciudades");
        }
    }
}