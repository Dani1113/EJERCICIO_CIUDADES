package com.example.ejercicio_ciudades;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.ejercicio_ciudades.Clases.Ciudad;
import com.example.ejercicio_ciudades.Clases.ListaCiudadesAdapter;
import com.example.ejercicio_ciudades.Controladores.CiudadesController;

import java.util.ArrayList;

public class MostrarCiudadesActivity extends AppCompatActivity {

    private RecyclerView rwCiudades = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_ciudades);
        rwCiudades = (RecyclerView) findViewById(R.id.rwCiudades);
        ArrayList<Ciudad> ciudades = CiudadesController.obtenerCiudades();
        ListaCiudadesAdapter adapter = new ListaCiudadesAdapter(this, ciudades);
        rwCiudades.setAdapter(adapter);
        rwCiudades.setLayoutManager(new LinearLayoutManager(this));
    }
}