package com.example.bdfactura;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

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
        registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String mcedula = cedula.getText().toString().trim();
                String mnombres = nombres.getText().toString().trim();
                String mcontras = contras.getText().toString().trim();
                registrarUsuario(mcedula,mnombres,mcontras);
            }
        });
    }

    private void registrarUsuario(String mcedula, String mnombres, String mcontras) {
        //Buscar la cedula, en la tabla usuario
        //instanciar la clase database
        database ohelper = new database(getApplicationContext(),"bdfactura",null,1);
        //instanciar el objeto de SQLiteDataBase
        SQLiteDatabase db = ohelper.getReadableDatabase();
        String Sqlquery = "select cedula From Cliente Where cedula = '" +mcedula+"'";
        //tablacursor ContentValues
        Cursor ccliente = db.rawQuery(Sqlquery,null);
        if (ccliente.moveToFirst()){
            Toast.makeText(getApplicationContext(), "Cedula ya Registrada!!", Toast.LENGTH_SHORT).show();
        }
        else{
            //Agregar usuario
            SQLiteDatabase dbad = ohelper.getWritableDatabase();
            //Crear una tabla tipo ContentValues para qque tenga los mismos campos de la tabla física
            try {
                ContentValues cvusuario = new ContentValues();
                cvusuario.put("cedula",mcedula);
                cvusuario.put("nombres",mnombres);
                cvusuario.put("contras",mcontras);
                dbad.insert("cliente",null,cvusuario);
                dbad.close();
                Toast.makeText(getApplicationContext(),"Usuario Agregado",Toast.LENGTH_SHORT).show();
            }
            catch (Exception e){
                Toast.makeText(getApplicationContext(),"Error: "+e.getMessage(),Toast.LENGTH_SHORT).show();
            }

        }
    }
}