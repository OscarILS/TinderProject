package com.example.tindermain

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

//Nuestra clase SQLHelper es heredada de SQLiteOpenHelper
//Completamos nuestro constructor SQLHelper

class SQLHelper(context: Context) : SQLiteOpenHelper(
    context, "datos.db", null, 1) {

    override fun onCreate(db: SQLiteDatabase?) {
        val ordenCreacion = "CREATE TABLE datos"+"(_id INTEGER PRIMARY KEY AUTOINCREMENT,"+
                "nombre_completo TEXT, genero TEXT, edad INT, facultad TEXT, correo_electronico TEXT, contrasenia TEXT)"
        db!!.execSQL(ordenCreacion)
    }

    override fun onUpgrade(db: SQLiteDatabase?,
                oldVersion: Int, newVersion: Int) {
        val ordenBorrado = "DROP TABLE IF EXISTS datos"
        db!!.execSQL(ordenBorrado)
        onCreate(db)
    }

    fun aniadirDatos(nombre: String, genero: String, edad: String, facultad:String, correo_electronico: String, contrasenia: String){
        val datosvarios = ContentValues()
        datosvarios.put("nombre_completo",nombre)
        datosvarios.put("genero",genero)
        datosvarios.put("edad",edad)
        datosvarios.put("facultad",facultad)
        datosvarios.put("correo_electronico",correo_electronico)
        datosvarios.put("contrasenia",contrasenia)
        val db = this.writableDatabase
        db.insert("datos",null,datosvarios)
        db.close()
    }

}