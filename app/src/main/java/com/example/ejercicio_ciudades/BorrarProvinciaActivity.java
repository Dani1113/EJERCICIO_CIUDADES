package com.example.ejercicio_ciudades;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.ejercicio_ciudades.Clases.Provincia;
import com.example.ejercicio_ciudades.Controladores.ProvinciaController;

import java.util.ArrayList;

public class BorrarProvinciaActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private Spinner spProvincias;
    private ArrayList<Provincia> provincias = null;
    private ArrayAdapter adaptador;
    private Provincia pSeleccionada = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_borrar_provincia);
        Spinner spProvincias = (Spinner) findViewById(R.id.spProvincias);
        provincias = new ArrayList<Provincia>();
        provincias.add(new Provincia("madrid"));
        //provincias = ProvinciaController.obtenerProvincias();
        spProvincias.setOnItemSelectedListener(this);
        adaptador = new ArrayAdapter<Provincia>(this, R.layout.support_simple_spinner_dropdown_item, provincias);
        spProvincias.setAdapter(adaptador);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        try{
            pSeleccionada = (Provincia) spProvincias.getItemAtPosition(position);
        }catch (Exception e){
            System.out.println("Error");
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void borrarProvincia(View view) {
        if(pSeleccionada == null){
            Toast.makeText(this, "Seleccionar una provincia para borrarla", Toast.LENGTH_SHORT).show();
            return;
        }
        AlertDialog.Builder alertaBorrar = new AlertDialog.Builder(this);
        alertaBorrar.setTitle("¿Quieres borrar la provincia seleccionada?");
        alertaBorrar.setPositiveButton("Sí", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                boolean borradoOk = ProvinciaController.borrarProvincia(pSeleccionada);
                if(borradoOk){
                    mostrarToast("Provincia borrada correctamente");
                    adaptador.remove(pSeleccionada);
                }else{
                    mostrarToast("Error al borrar la provincia");
                }
            }
        });
        alertaBorrar.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                mostrarToast("Operación de borrado cancelada");
            }
        });
        alertaBorrar.show();
    }

    private void mostrarToast(String mensaje) { //Este tipo de métodos globales es mejor hacerlos en una clase a parte
        Toast.makeText(this, mensaje, Toast.LENGTH_SHORT).show();
    }
}