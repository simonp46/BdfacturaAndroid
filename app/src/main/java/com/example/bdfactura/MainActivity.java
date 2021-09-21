package com.example.bdfactura;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    // Instanciar objetos
    EditText usuariol,contrasl;
    TextView registrarseaquil;
    Button iniciarsesionl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        usuariol = findViewById(R.id.etEmail);
        contrasl = findViewById(R.id.etContraR);
        registrarseaquil = findViewById(R.id.tvregist);
        iniciarsesionl = findViewById(R.id.btnini);
        registrarseaquil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),Registrar.class));
            }
        });

        iniciarsesionl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String musuario = usuariol.getText().toString().trim();
                String mcontras = contrasl.getText().toString().trim();
                IniciarSesion(musuario,mcontras);

            }
        });

    }
    private void IniciarSesion(String musuario,String mcontras) {
        database ohelper = new database(getApplicationContext(),"bdfactura", null,1);
        SQLiteDatabase dbread = ohelper.getReadableDatabase();
        String Sqlquery = "select cedula,nombres From Cliente Where email = '" +musuario+"' and contras = '"+mcontras+"'";
        //tablacursor ContentValues
        Cursor ccliente = dbread.rawQuery(Sqlquery,null);
        if (ccliente.moveToFirst()){
            Toast.makeText(getApplicationContext(), "Email y contraseña encontradas!!", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(getApplicationContext(), "Email y/o contraseña incorrectos!!", Toast.LENGTH_SHORT).show();
        }
    }
}