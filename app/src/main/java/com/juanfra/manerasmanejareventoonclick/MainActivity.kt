package com.juanfra.manerasmanejareventoonclick

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

/*
Autor: Juan Francisco Sánchez González
Fecha: 07/10/2024
Clase: Actividad que muestra las 3 formas diferentes de eventos click que se pueden realizar en Android
con un botón: A través del XML (Obsoleta), asociando el manejador de eventos al botón  e implementanado
OnClickListener como interfaz de la Activity
*/

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var btnEvento: Button
    private lateinit var btnInterfaz1: Button
    private lateinit var btnInterfaz2: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        initBtnEvento()

        initBtnInterfaz()
    }

    // Desde el XML (primer botón) la funcion debe ser pública y hay que pasarle un solo
    // parametro de tipo View
    fun onClickXML(v: View) {
        Toast.makeText(this, getString(R.string.btnxml_toast), Toast.LENGTH_LONG).show()
    }

    // Asociando el listener al botón (segundo botón)
    private fun initBtnEvento() {
        btnEvento = findViewById(R.id.btnEvento)
        btnEvento.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View?) {
                Toast.makeText(applicationContext, getString(R.string.btnevento_toast), Toast.LENGTH_LONG).show()
            }
        })
    }

    // Instanciando los botones para la 3º forma (utilizando la interfaz OnClickListener)
    private fun initBtnInterfaz() {
        btnInterfaz1 = findViewById(R.id.btnInterfaz1)
        btnInterfaz2 = findViewById(R.id.btnInterfaz2)
        btnInterfaz1.setOnClickListener(this)
        btnInterfaz2.setOnClickListener(this)
    }

    // Implementado la interfaz OnClickListener en la actividad (tercer y cuarto botón)
    override fun onClick(v: View) {
        when(v.id) {
            R.id.btnInterfaz1 -> Toast.makeText(this, getString(R.string.btnint1_toast), Toast.LENGTH_LONG).show()
            R.id.btnInterfaz2 -> Toast.makeText(this, getString(R.string.btnint2_toast), Toast.LENGTH_LONG).show()
        }
    }

}