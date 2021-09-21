package com.example.bdfactura;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class database extends SQLiteOpenHelper {
    // Definir las tablas
    String tblcliente = "CREATE TABLE cliente (id text primary key,name text,email text,password text)";
    String tblfactura = "CREATE TABLE factura (nrofac integer primary key, id text, fecha text, Vlrfact integer, saldofact integer)";
    String tblabono = "CREATE TABLE abono (nropago integer primary key autoincrement, nrofact integer, fecha text, valor integer )";
    public database( Context context,  String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //Creación tablas
        db.execSQL(tblcliente);
        db.execSQL(tblfactura);
        db.execSQL(tblabono);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE cliente");
        db.execSQL(tblcliente);
        db.execSQL("DROP TABLE factura");
        db.execSQL(tblfactura);
        db.execSQL("DROP TABLE abono");
        db.execSQL(tblabono);
    }
}
