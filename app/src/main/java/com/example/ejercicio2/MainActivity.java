package com.example.ejercicio2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import java.util.Calendar;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button botFecha;
    private EditText edtFecha;
    private int dia, mes, anio;
    private EditText edtNombreCompleto;
    private EditText edtTelefono;
    private EditText edtEmail;
    private EditText edtDescripcion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtNombreCompleto = (EditText) findViewById(R.id.edtNombreCompleto);
        edtTelefono = (EditText) findViewById(R.id.edtTelefono);
        edtDescripcion = (EditText) findViewById(R.id.edtDescripcion);
        edtEmail = (EditText) findViewById(R.id.edtEmail);

        botFecha = (Button) findViewById(R.id.botFecha);
        edtFecha = (EditText) findViewById(R.id.edtFecha);
        botFecha.setOnClickListener(this);
        edtFecha.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        if (v==botFecha){
            final Calendar c= Calendar.getInstance();
            dia = c.get(Calendar.DAY_OF_MONTH);
            mes = c.get(Calendar.MONTH);
            anio = c.get(Calendar.YEAR);
            DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                edtFecha.setText(dayOfMonth + " / " + (monthOfYear+1)+ " / " + year);

                }
                }
                ,dia, mes, anio);
                datePickerDialog.show();
            }
        }

        public void Enviar (View view){

        Intent i = new Intent(this, confirmarContacto.class);
        i.putExtra("nombre", edtNombreCompleto.getText().toString());
        i.putExtra("telefono", edtTelefono.getText().toString());
        i.putExtra("email", edtEmail.getText().toString());
        i.putExtra("descripcion", edtDescripcion.getText().toString());
        i.putExtra( "fecha", edtFecha.getText().toString());
        startActivity(i);


        }
    }



