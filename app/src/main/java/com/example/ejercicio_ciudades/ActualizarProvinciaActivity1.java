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
    //public static final String EXTRA_FOTO = "FotoEnviada";
    ////public static final String EXTRA_NOMBRE = "NombreEnviado";
    //public static final String EXTRA_ID = "IdEnviada";
    private Spinner spActualizarProvincia;
    private ArrayList<Provincia> provincias = null;
    public static ArrayAdapter<Provincia> adaptador = null;
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
        if(provincias != null){
            pSeleccionada = (Provincia) spActualizarProvincia.getItemAtPosition(position);
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
            intent.putExtra(EXTRA_OBJETO_PROVINCIA, pSeleccionada); //-> No vale
            //Bitmap foto = pSeleccionada.getFoto();
            //ImageView imgProvincia = new ImageView(this);
            //if(foto != null){ -> Si la foto obtenida es null mostrará la imagen por defecto (la que indicas en el image view del diseño)
            //   imagenProvincia.setText(foto);
            //   intent.putExtra(EXTRA_IMAGEN_PROVINCIA, (Parcelable) imgProvincia);
            //}else {
            //   intent.putExtra(EXTRA_IMAGEN_PROVINCIA, (Parcelable) null);
            //}
            //intent.putExtra(EXTRA_OBJETO_PROVINCIA, pSeleccionada.getNombre());
            //intent.putExtra(EXTRA_OBJETO_PROVINCIA, pSeleccionada.getIdProvincia());
            startActivity(intent);
        }
    }
}