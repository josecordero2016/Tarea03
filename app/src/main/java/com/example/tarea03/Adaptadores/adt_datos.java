package com.example.tarea03.Adaptadores;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.example.tarea03.Modelos.Restaurantes.*;
import com.example.tarea03.R;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class adt_datos extends RecyclerView.Adapter<adt_datos.ViewHolder_dts> {

    private Restaurante[] datos;

    public adt_datos(Restaurante[] datos) {
        this.datos = datos;
    }

    @Override
    public ViewHolder_dts onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = null;
        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.lyt_items,null,false);
        return new ViewHolder_dts(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder_dts holder, int position) {
        try{holder.asig_dts(datos[position]);} catch (Exception e){}
    }

    @Override
    public int getItemCount() {
        return datos.length;
    }

    public class ViewHolder_dts extends RecyclerView.ViewHolder {

        TextView lblNombre, lblCategoria, lblHorarios, lblTelefono;
        ImageView imgPerfil;

        public ViewHolder_dts(@NonNull View itemView) {
            super(itemView);
            lblNombre = (TextView) itemView.findViewById(R.id.lblNombre);
            lblCategoria = (TextView) itemView.findViewById(R.id.lblCategoria);
            lblHorarios = (TextView) itemView.findViewById(R.id.lblHorarios);
            lblTelefono = (TextView) itemView.findViewById(R.id.lblTelefono);
            imgPerfil = (ImageView) itemView.findViewById(R.id.imgPerfil);
        }

        public void asig_dts(Restaurante r) {
            //Asignando los valores
            lblNombre.setText(r.getNombre());
            lblHorarios.setText(r.getHorarios());
            lblCategoria.setText(r.getCategoria());
            lblTelefono.setText(r.getTelefono());
            Glide.with(itemView).load(r.getFoto())
            .centerCrop()
            .into(imgPerfil);
        }
    }
}
