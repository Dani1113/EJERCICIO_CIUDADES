package com.example.ejercicio_ciudades.Clases;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ejercicio_ciudades.R;

import java.util.ArrayList;

public class ListaCiudadesAdapter extends RecyclerView.Adapter<CiudadViewHolder> {

    //ATRIBUTOS
    private LayoutInflater inflater;
    private Context c;
    private ArrayList<Ciudad> listaCiudades;

    //CONSTRUCTOR
    public ListaCiudadesAdapter(Context c, ArrayList<Ciudad> listaCiudades) {
        this.c = c;
        this.listaCiudades = listaCiudades;
        inflater = LayoutInflater.from(c);
    }

    @NonNull
    @Override
    public CiudadViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = inflater.inflate(R.layout.item_rw_ciudades, parent, false);
        return new CiudadViewHolder(itemView, this);
    }

    @Override
    public void onBindViewHolder(@NonNull CiudadViewHolder holder, int position) {
        Ciudad ciudadSeleccionada = listaCiudades.get(position);
        holder.txtNombre.setText("NOMBRE: " + ciudadSeleccionada.getNombre());
        holder.txtHabitantes.setText("HABITANTES: " + ciudadSeleccionada.getHabitantes());
        holder.txtProvincia.setText("PROVINCIA: " + ciudadSeleccionada.getIdprovincia());
    }

    @Override
    public int getItemCount() {
        return listaCiudades.size();
    }
}
