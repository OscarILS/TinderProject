package com.example.tindermain

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // accion cuando se presiona el boton ingresar
        /*
        botonIngresar.setOnClickListener{
            var correo = textoCorreo.text.toString();
            var contra = textoContra.text.toString();

        }
        */
        //accion cuando se presiona el boton registrar
        //se debe abrir otra activity
        botonRegistro.setOnClickListener{
            val intent = Intent(this, Registro::class.java)
            startActivity(intent)
        }


    }
}