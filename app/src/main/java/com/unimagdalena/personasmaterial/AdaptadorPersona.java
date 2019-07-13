package com.unimagdalena.personasmaterial;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class AdaptadorPersona extends RecyclerView.Adapter<AdaptadorPersona.PersonaViewHolder>{
    private ArrayList<Persona> personas;

    public AdaptadorPersona(ArrayList<Persona> personas){
        this.personas = personas;
    }

    @Override
    public PersonaViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        //COMO VOY A MOSTRAR
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_persona, viewGroup,false);
        return new PersonaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull PersonaViewHolder personaViewHolder, int i) {
        //QUE VOY A MOSTRAR
        Persona p = personas.get(i);
        personaViewHolder.foto.setImageResource(p.getFoto());
        personaViewHolder.nombre.setText(p.getNombre());
        personaViewHolder.apellido.setText(p.getApellido());
    }

    @Override
    public int getItemCount() {
        return personas.size();
    }

    public static class PersonaViewHolder extends RecyclerView.ViewHolder{

        private ImageView foto;
        private TextView nombre;
        private TextView apellido;
        private View v;

        public PersonaViewHolder(View itemView) {
            super(itemView);
            v = itemView;
            foto = v.findViewById(R.id.foto);
            nombre = v.findViewById(R.id.lbl_nombre);
            apellido = v.findViewById(R.id.lbl_apellido);
        }
    }
}
