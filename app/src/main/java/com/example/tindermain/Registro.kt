package com.example.tindermain

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.tindermain.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_registro.*
import kotlinx.android.synthetic.main.activity_registro.view.*

class Registro : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var datosDBHelper: SQLHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_registro)

        datosDBHelper = SQLHelper(this)

            botonRegister.setOnClickListener{
            if (registroNombre.text.isNotBlank() && registroGenero.text.isNotBlank() && registroEdad.text.isNotBlank() && registroFacultad.text.isNotBlank() && registroBase.text.isNotBlank() && registroCelular.text.isNotBlank()) {
                datosDBHelper.aniadirDatos(
                    registroNombre.text.toString(),
                    registroGenero.text.toString(),
                    registroEdad.text.toString(),
                    registroFacultad.text.toString(),
                    registroBase.text.toString(),
                    registroCelular.text.toString()
                )
                Toast.makeText(this, "Guardado", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "No se ha podido guardar", Toast.LENGTH_SHORT).show()
            }
        }
        botonVolver.setOnClickListener{
            val intent= Intent(this,MainActivity::class.java)
            startActivity(intent)
        }
    }
}