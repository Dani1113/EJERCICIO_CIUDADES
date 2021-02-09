package com.example.ejercicio_ciudades.Clases;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ejercicio_ciudades.DetallesCiudadActivity;
import com.example.ejercicio_ciudades.R;

import java.util.ArrayList;

public class CiudadViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

    public static final String EXTRA_OBJETO_CIUDAD = "ciudad";
    public TextView txtNombre;
    public TextView txtHabitantes;
    public TextView txtProvincia;
    public ListaCiudadesAdapter adapter;

    //CONSTRUCTOR
    public CiudadViewHolder(@NonNull View itemView, ListaCiudadesAdapter adapter) {
        super(itemView);
        txtNombre = (TextView) itemView.findViewById(R.id.txtNombre);
        txtHabitantes = (TextView) itemView.findViewById(R.id.txtHabitantes);
        txtProvincia = (TextView) itemView.findViewById(R.id.txtProvincia);
        this.adapter = adapter;
        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Log.i("Ciudades", "Al hacer click muestro la casilla");
        int posicion = getLayoutPosition();
        Ciudad c = this.adapter.getListaCiudades().get(posicion);
        Intent intent = new Intent(this.adapter.getC(), DetallesCiudadActivity.class);
        intent.putExtra(EXTRA_OBJETO_CIUDAD, c);
        this.adapter.getC().startActivity(intent);
    }
}
