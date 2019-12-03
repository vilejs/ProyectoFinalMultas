package com.uisrael.proyectofinalmultas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import OpenHelper.SQLite_OpenHelper;

public class MainActivity extends AppCompatActivity {


    Button btnRegistrarse, btnIngresar, btnMostrarUsuario;
    SQLite_OpenHelper helper= new SQLite_OpenHelper(this,"BASE", null,1);



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnRegistrarse = (Button) findViewById(R.id.btnRegistrar);

        btnRegistrarse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Registro.class);
                startActivity(intent);

            }
        });

        btnIngresar = (Button) findViewById(R.id.btnIniciar);
        btnIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText txtusu=(EditText)findViewById(R.id.edtUsuario);
                EditText txtpass=(EditText)findViewById(R.id.edtContrasena);

                try {

                    Cursor cursor=helper.ConsultarUsuPas(txtusu.getText().toString(),txtpass.getText().toString());

                    if(cursor.getCount()>0){

                        Intent intent= new Intent(getApplicationContext(),Menu.class);
                        startActivity(intent);


                    }else {
                        Toast.makeText(getApplicationContext(), "Usuario incorrecto", Toast.LENGTH_LONG).show();
                    }
                    txtusu.setText("");
                    txtpass.setText("");
                    txtusu.findFocus();
                } catch (SQLException e){

                    e.printStackTrace();
                }

            }
        });
    }



}
