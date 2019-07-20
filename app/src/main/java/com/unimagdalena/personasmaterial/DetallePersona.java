package com.unimagdalena.personasmaterial;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class DetallePersona extends AppCompatActivity {
    private TextView nombre, apellido;
    private ImageView foto;
    private Bundle bundle;
    private Intent i;
    private int fot;
    private String nom, ape, id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_persona);
        nombre = findViewById(R.id.lblNombreDetalle);
        apellido = findViewById(R.id.lbApellidoDetalle);
        foto = findViewById(R.id.foto);
        i = getIntent();
        bundle = i.getBundleExtra("datos");
        nom = bundle.getString("nombre");
        ape = bundle.getString("apellido");
        fot = bundle.getInt("foto");
        id = bundle.getString("id");

        nombre.setText(nom);
        apellido.setText(ape);
        foto.setImageResource(fot);
    }

    public void onBackPressed(){
        finish();
        Intent i = new Intent(DetallePersona.this, MainActivity.class);
        startActivity(i);
    }

    public void eliminar(View v){
        String positivo, negativo;
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.titulo_eliminar);
        builder.setMessage(R.string.mensaje_eliminar);
        positivo = getString(R.string.positivo);
        negativo=getString(R.string.negativo);

        builder.setPositiveButton(positivo, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Persona p = new Persona();
                p.setId(id);
                p.eliminar();
                onBackPressed();
            }
        });

        builder.setNegativeButton(negativo, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();
    }
}
