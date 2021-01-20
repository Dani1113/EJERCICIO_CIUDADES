package com.example.ejercicio_ciudades;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ejercicio_ciudades.Clases.Provincia;
import com.example.ejercicio_ciudades.Controladores.ProvinciaController;

public class ActualizarProvinciaAvtivity2 extends AppCompatActivity {

    private EditText edtActutalizarID = null;
    private EditText edtActualizarNombre = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actualizar_provincia_avtivity2);
        Intent intent = getIntent();
        Provincia pSeleccionada = (Provincia) intent.getSerializableExtra(ActualizarProvinciaActivity1.EXTRA_OBJETO_PROVINCIA);
        edtActutalizarID = (EditText) findViewById(R.id.edtProvinciaID);
        edtActualizarNombre = (EditText) findViewById(R.id.edtProvinciaNombre);
        edtActutalizarID.setText((String.valueOf(pSeleccionada.getIdprovincia())));
        edtActualizarNombre.setText(String.valueOf(pSeleccionada.getNombre()));
        edtActutalizarID.setEnabled(false);
    }

    public void actualizarDatosProvinciaActivity2(View view) {
        int id = Integer.valueOf(String.valueOf(edtActutalizarID.getText()));
        String nombre = String.valueOf(edtActualizarNombre.getText());
        Provincia p = new Provincia(id, nombre);
        boolean actualizadoOk = ProvinciaController.actualizarProvincia(p);
        if(actualizadoOk){
            Toast.makeText(this, "Actualizado correctamente", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "Error al actualizar", Toast.LENGTH_SHORT).show();
        }
    }
}