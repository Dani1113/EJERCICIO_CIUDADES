package com.example.ejercicio_ciudades;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.ejercicio_ciudades.Clases.Provincia;
import com.example.ejercicio_ciudades.Controladores.ProvinciaController;

import java.util.ArrayList;

public class ActualizarProvinciaActivity1 extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    public static final String EXTRA_OBJETO_PROVINCIA = "ProvinciaEnviada";
    private Spinner spActualizarProvincia;
    private ArrayList<Provincia> provincias = null;
    public static ArrayAdapter<Provincia> adaptador;
    private Provincia pSeleccionada = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actualizar_provincia1);
        spActualizarProvincia = (Spinner) findViewById(R.id.spActualizarProvincia);
        provincias = ProvinciaController.obtenerProvincias();
        spActualizarProvincia.setOnItemSelectedListener(this);
        if(provincias != null) {
            adaptador = new ArrayAdapter<Provincia>(this, R.layout.support_simple_spinner_dropdown_item, provincias);
            spActualizarProvincia.setAdapter(adaptador);
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        try{
            pSeleccionada = (Provincia) spActualizarProvincia.getItemAtPosition(position);
            Toast.makeText(this, "Has elegido la provincia" + pSeleccionada.toString(), Toast.LENGTH_SHORT).show();
        }catch (Exception e){
            System.out.println("Error");
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void actualizarProvinciaActivity2(View view) {
        if(pSeleccionada == null){
            Toast.makeText(this, "Debes seleccionar una provincia", Toast.LENGTH_SHORT).show();
            return;
        }else{
            Intent intent = new Intent(this, ActualizarProvinciaActivity2.class);
            intent.putExtra(EXTRA_OBJETO_PROVINCIA, pSeleccionada);
            startActivity(intent);
        }
    }
}