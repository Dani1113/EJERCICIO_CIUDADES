package com.example.ejercicio_ciudades;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import com.example.ejercicio_ciudades.Clases.Ciudad;
import com.example.ejercicio_ciudades.Clases.CiudadViewHolder;

public class DetallesCiudadActivity extends AppCompatActivity {

    private TextView txtNombre = null;
    private TextView txtHabitantes = null;
    private TextView txtProvincia = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalles_ciudad);
        txtNombre = findViewById(R.id.txtNombreDetalle);
        txtHabitantes = findViewById(R.id.txtHabitantesDetalle);
        txtProvincia = findViewById(R.id.txtProvinciaDetalle);
        Intent intent = getIntent();
        if(intent != null){
            Ciudad c = (Ciudad) intent.getSerializableExtra(CiudadViewHolder.EXTRA_OBJETO_CIUDAD);
            txtNombre.setText("NOMBRE CIUDAD: " + c.getNombre());
            txtHabitantes.setText("HABITANTES: " + c.getHabitantes());
            txtProvincia.setText("PROVINCIA: " + c.getIdprovincia());
        }
    }
}