package com.example.primerproyecto

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class SegundaActivity : AppCompatActivity() {

    private var nombre: String? = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_segunda)

        val button = findViewById<Button>(R.id.btn_accion)
        val texto = findViewById<TextView>(R.id.txt_output)
        intent.extras?.let { bundle -> nombre = bundle.getString("nombre","") }

        texto.text = nombre

        button.setOnClickListener{
            val intent = Intent()
            intent.putExtra("nombre2","Hola desde segunda activity")
            /* TODO Le pasamos al result un valor de Ok ademas del intent */
            setResult(Activity.RESULT_OK, intent)

            /* TODO Lo que hace es matar la activity actual , como el activity predecesor esta
                de este actual, veremos la activity anterior */
            finish()
        }
    }

    private fun navegarMainActivity(){
        // TODO Para poder ir de esta vista al segundo destino
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}