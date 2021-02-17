package com.example.ejercicio_ciudades;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ejercicio_ciudades.Clases.Provincia;
import com.example.ejercicio_ciudades.Controladores.ProvinciaController;

public class ActualizarProvinciaActivity2 extends AppCompatActivity {

    private EditText edtActutalizarID = null;
    private EditText edtActualizarNombre = null;
    private Provincia pSeleccionada = null;
    //private ImageView imagenProvincia = null; -> Imagen que mostrará las ciudades obtenidas, en el diseño poner las medidas de la imagen que recogemos

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actualizar_provincia_avtivity2);
        Intent intent = getIntent();
        pSeleccionada = (Provincia) intent.getSerializableExtra(ActualizarProvinciaActivity1.EXTRA_OBJETO_PROVINCIA); //-> No vale
        //edtActutalizarID.setText(intent.getIntExtra(ActualizarProvinciaActivity1.EXTRA_ID));
        //edtActutalizarID.setText(intent.getStringExtra(ActualizarProvinciaActivity1.EXTRA_NOMBRE));
        //imagenProvincia = intent.getParcelableExtra(ActualizarProvinciaActivity1.EXTRA_FOTO)
        edtActutalizarID = (EditText) findViewById(R.id.edtProvinciaID);
        edtActualizarNombre = (EditText) findViewById(R.id.edtProvinciaNombre);
        edtActutalizarID.setText((String.valueOf(pSeleccionada.getIdprovincia())));
        edtActualizarNombre.setText(String.valueOf(pSeleccionada.getNombre()));
        //imagenProvincia = (ImageView) findViewById(R.id.imagenProvincia);

        edtActutalizarID.setEnabled(false);
    }

    public void actualizarDatosProvinciaActivity2(View view) {
        int id = Integer.valueOf(String.valueOf(edtActutalizarID.getText()));
        String nombre = String.valueOf(edtActualizarNombre.getText());
        Provincia p = new Provincia(id, nombre);
        boolean actualizadoOk = ProvinciaController.actualizarProvincia(p);
        if(actualizadoOk){
            ActualizarProvinciaActivity1.adaptador.remove(pSeleccionada);
            ActualizarProvinciaActivity1.adaptador.add(p);
            Toast.makeText(this, "Provincia actualizada correctamente", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "Error al actualizar la provincia", Toast.LENGTH_SHORT).show();
        }
    }
}