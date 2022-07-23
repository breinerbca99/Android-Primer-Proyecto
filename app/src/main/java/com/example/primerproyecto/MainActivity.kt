package com.example.primerproyecto

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts

class MainActivity : AppCompatActivity() {

    // TODO Es una promesa que vamos inicializar
    private lateinit var texto: TextView

    /* Este evento es el que inicia al activity */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Que es lo que estamos tratando de buscar ? <>
        texto = findViewById<TextView>(R.id.txt_output)
        val boton = findViewById<Button>(R.id.btn_accion)

        // Cuando se apriete el boton va cambiar el texto
        boton.setOnClickListener{
            /* Ahora en esta variable texto, tendremos todas las propiedades del TextView
            que le podriamos a ver dado en el xml */
            texto.text = "Curso Android"
            navegarSegundaActivity()
        }
        Log.d("LiceCycle","onCreate")
    }

    private fun navegarSegundaActivity(){
        /* TODO Para poder ir de esta vista al segundo destino
                El intent es el encargado de la navegacion,
                este puede enviar parametros hacia otros destinos */
        val intent = Intent(this, SegundaActivity::class.java)
        intent.putExtra("nombre", "Breiner Roiser")
        // startActivity(intent)
        // StarActivity y vamos a esperar un resultado
        /* TODO (startActivityForResult) Estamos iniciando una actividad
                pero especificamos que realizamos dicha actividad esperando un resultado */
        startActivityForResult.launch(intent)
    }

    private val startActivityForResult =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
            if (it.resultCode == Activity.RESULT_OK){
                texto.text = it.data?.getStringExtra("nombre2")
            }
        }

    override fun onStart() {
        super.onStart()
        Log.d("LiceCycle","onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d("LiceCycle","onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("LiceCycle","onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("LiceCycle","onStop")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("LiceCycle","onRestart")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("LiceCycle","onDestroy")
    }

    /*TODO Siempre se ejecuta al iniciar la aplicacion : onCreate, onStart, onResume*/
}