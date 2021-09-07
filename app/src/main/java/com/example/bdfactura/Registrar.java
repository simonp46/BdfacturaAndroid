package com.example.bdfactura;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Registrar extends AppCompatActivity {
    //instanciar objetos de activity_registrar.xml
    EditText cedula, nombres, contras;
    TextView iniciarsesionr;
    Button registrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar);
        cedula = findViewById(R.id.etCedR);
        nombres = findViewById(R.id.etNom);
        contras = findViewById(R.id.etContraR);
        iniciarsesionr = findViewById(R.id.tvIniR);
        registrar = findViewById(R.id.btnreg);
    }
}