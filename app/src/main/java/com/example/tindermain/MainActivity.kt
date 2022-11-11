package com.example.tindermain

import android.content.Intent
import android.database.sqlite.SQLiteDatabase
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.tindermain.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var datosDBHelper: SQLHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_main)

        // accion cuando se presiona el boton ingresar

        binding.botonIngresar.setOnClickListener{
            var verificador = 0
            val correo = textoCorreo.text.toString();
            val contra = textoContra.text.toString();
            val db: SQLiteDatabase = datosDBHelper.readableDatabase
            val cursor = db.rawQuery("SELECT * FROM datos",null)

            if (cursor.moveToFirst()){
                do{
                    if(correo == cursor.getString(4).toString() && contra == cursor.getString(5).toString()) {
                        Toast.makeText(this, "Iniciando sesion.", Toast.LENGTH_SHORT).show()
                        verificador = 1
                    }
                }while (cursor.moveToNext())
            }
            if (verificador==1){
                val intent = Intent(this,seleccionMatch::class.java)
                startActivity(intent)
            }
        }
        //accion cuando se presiona el boton registrar
        //se debe abrir otra activity
        botonRegistro.setOnClickListener{
            val intent = Intent(this, Registro::class.java)
            startActivity(intent)
        }
    }
}