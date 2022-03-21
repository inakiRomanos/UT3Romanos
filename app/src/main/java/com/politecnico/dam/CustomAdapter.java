package com.politecnico.dam;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


@SuppressWarnings("CanBeFinal")
public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {

    ArrayList<String> nombreCentro;
    ArrayList<String> direccionCentro;
    ArrayList<String> localidadCentro;
    ArrayList<String> telefonoCentro;
    Context context;

    public CustomAdapter(Context context, ArrayList<String> nombreCentro, ArrayList<String> direccionCentro, ArrayList<String> localidadCentro, ArrayList<String> telefonoCentro) {
        this.context = context;
        this.nombreCentro = nombreCentro;
        this.direccionCentro = direccionCentro;
        this.localidadCentro = localidadCentro;
        this.telefonoCentro = telefonoCentro;
    }

    @SuppressWarnings("NullableProblems")
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // infalte the item Layout
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.rowlayout, parent, false);
        @SuppressWarnings("UnnecessaryLocalVariable") MyViewHolder vh = new MyViewHolder(v); // pass the view to View Holder
        return vh;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, @SuppressLint("RecyclerView") final int position) {
        // set the data in items
        holder.nombre.setText(nombreCentro.get(position));
        holder.direccion.setText(direccionCentro.get(position));
        holder.localidad.setText(localidadCentro.get(position));
        holder.telefono.setText(telefonoCentro.get(position));
        // implement setOnClickListener event on item view.
        //noinspection Convert2Lambda
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // display a toast with person name on item click
                Toast.makeText(context, telefonoCentro.get(position), Toast.LENGTH_SHORT).show();
            }
        });

    }


    @Override
    public int getItemCount() {
        return nombreCentro.size();
    }

    @SuppressWarnings({"CanBeFinal", "InnerClassMayBeStatic"})
    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView nombre, direccion, localidad, telefono;// init the item view's

        public MyViewHolder(View itemView) {
            super(itemView);

            // get the reference of item view's
            nombre = itemView.findViewById(R.id.nombre);
            direccion = itemView.findViewById(R.id.direccion);
            localidad = itemView.findViewById(R.id.localidad);
            telefono = itemView.findViewById(R.id.telefono);

        }
    }
}