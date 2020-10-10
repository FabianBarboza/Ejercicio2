package com.example.ejercicio2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class confirmarContacto extends AppCompatActivity {
    private TextView edtNombreCompleto;
    private TextView edtTelefono;
    private TextView edtEmail;
    private TextView edtDescripcion;
    private TextView edtFecha;
    private Button btnVolver;
    private Button btnOk;
    @Override
   protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmar_contacto);
        //Boton Volver campos llenos
        btnVolver = (Button) findViewById(R.id.btnVolver);
        btnVolver.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                onBackPressed();
            }

        });
        //Rescato Textos
        edtNombreCompleto = (TextView) findViewById(R.id.edtNombreCompleto);
        edtTelefono = (TextView) findViewById(R.id.edtTelefono);
        edtDescripcion = (TextView) findViewById(R.id.edtDescripcion);
        edtEmail = (TextView) findViewById(R.id.edtEmail);
        edtFecha = (TextView) findViewById(R.id.edtFecha);


        //Publico Textos
        Bundle parametros   = getIntent().getExtras();
        String nombre = parametros.getString("nombre");
        edtNombreCompleto.setText("Nombre: " + nombre);

        String telefono = parametros.getString("telefono");
        edtTelefono.setText("Teléfono: " + telefono);

        String email = parametros.getString("email");
        edtEmail.setText("Email: "+ email);

        String descripcion = parametros.getString("descripcion");
        edtDescripcion.setText("Descripcion: " + descripcion);

        String fecha = parametros.getString("fecha");
        edtFecha.setText("Fecha de Nacimiento : " + fecha);

    }
        // Vuelve al home de la app con los campos vacíos
    public void Enviar (View view){
        Intent home = new  Intent (this, MainActivity.class);
        startActivity(home);


    }


}