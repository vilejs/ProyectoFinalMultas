package com.uisrael.proyectofinalmultas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import OpenHelper.SQLite_OpenHelper;

public class Registro extends AppCompatActivity {


    Button btnGrabarUsu;
    EditText txtNombreUsu,txtCiudaUsu, txtCorreoUsu,txtPasswordUsu;

    SQLite_OpenHelper helper= new SQLite_OpenHelper(this,"BASE",null,1);



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        btnGrabarUsu=(Button)findViewById(R.id.btnregistarUsuario);
        txtNombreUsu=(EditText) findViewById(R.id.edtUsuarioNuevo);
        txtCiudaUsu=(EditText) findViewById(R.id.edtCiudadNuevo);
        txtCorreoUsu=(EditText) findViewById(R.id.edtCorreoNuevo);
        txtPasswordUsu=(EditText) findViewById(R.id.edtContrasenaNueva);

                btnGrabarUsu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                helper.abrir();
                helper.insertarReg(String.valueOf(txtNombreUsu.getText()),
                        String.valueOf(txtCiudaUsu.getText()),
                        String.valueOf(txtCorreoUsu.getText()),
                        String.valueOf(txtPasswordUsu.getText()));
                helper.cerrar();
                Toast.makeText(getApplicationContext(),"REGISTRO ALMACENADO",Toast.LENGTH_LONG).show();
                Intent intent= new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);

            }
        });



    }
}

