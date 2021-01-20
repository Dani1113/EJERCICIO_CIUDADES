package com.example.ejercicio_ciudades;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ejercicio_ciudades.Clases.Provincia;
import com.example.ejercicio_ciudades.Controladores.ProvinciaController;

public class NuevaProvinciaActivity extends AppCompatActivity {

    private EditText edtNombreProvincia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nueva_provincia);
        edtNombreProvincia = (EditText) findViewById(R.id.edtNombreProvincia);
    }

    public void insertarProvincia(View view) {
        //1º Recuperar datos del formulario
        String nombreProvincia = String.valueOf(edtNombreProvincia.getText());
        if(nombreProvincia.isEmpty()){
            edtNombreProvincia.setError("Debes introducir el nombre de la provincia");
        }else{
            AlertDialog.Builder confirmación = new AlertDialog.Builder(this);
            confirmación.setTitle("¿Quieres insertar la provincia?");
            confirmación.setPositiveButton("SÍ", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    //Insertar en la base de datos
                    Provincia p = new Provincia(nombreProvincia);
                    boolean insercionOk = ProvinciaController.insertarProvincia(p);
                    if(insercionOk){
                        mostrarToast("Provincia insertada correctamente");
                    }else{
                        mostrarToast("Error al insertar la provincia");
                    }
                }
            });
            confirmación.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    //Cancelar la inserción en la base de datos
                    mostrarToast("Operación de inserción cancelada"); //El contexto de Toast, no puede ser onClickListener
                }
            });
            confirmación.show(); //Muestra la alerta
        }

        //2º Crear hilo de ejecucion

        //3º Guardar info en la BD
    }

    private void mostrarToast(String mensaje) { //Este tipo de métodos globales es mejor hacerlos en una clase a parte
        Toast.makeText(this, mensaje, Toast.LENGTH_SHORT).show();
    }
}