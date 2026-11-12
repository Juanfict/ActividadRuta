package com.example.actividadruta

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val dataset = mutableListOf<Ruta>(
                            Ruta("Cumbre azul","8km - Media",150,R.drawable.bosque,true,"Sendero de montaña...")
                        , Ruta("Vuelta al lago","6km - Fácil",100,R.drawable.lago,false,"Vuelta por los aledaños de...")
        )
        val customAdapter = CustomAdapter(dataset,{ ruta ->
            Log.i("clicRuta","$ruta")
        }){ detalleRuta ->
            //clic al item
            val intent = Intent(this@MainActivity, DetalleActivity::class.java)
            intent.putExtra("objetoRuta",detalleRuta)
            startActivity(intent)
        }

        val recyclerView: RecyclerView = findViewById(R.id.recycler)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = customAdapter

    }
}