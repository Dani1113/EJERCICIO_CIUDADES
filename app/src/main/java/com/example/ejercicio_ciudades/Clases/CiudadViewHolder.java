package com.example.ejercicio_ciudades.Clases;

import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ejercicio_ciudades.R;

public class CiudadViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

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
    }
}
