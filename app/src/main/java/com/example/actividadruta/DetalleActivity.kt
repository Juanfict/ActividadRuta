package com.example.actividadruta

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.actividadruta.databinding.ActivityDetalleBinding

class DetalleActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetalleBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityDetalleBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //setContentView(R.layout.activity_detalle)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val ruta = intent.getParcelableExtra<Ruta>("objetoRuta", Ruta::class.java)
        binding.imgDetalle.setImageResource(ruta!!.imagen)
        binding.tTituloDetalle.text = ruta.titulo
        binding.tDificultadDetalle.text = ruta.dificultad
        binding.tMinutosDetalle.text = ruta.minutos.toString() + " minutos estimados"
        binding.tDescripcion.text = ruta.descripcion
        if(ruta.es_favorito)
            binding.imgFavDetalle.setImageResource(R.drawable.ic_favorito_on)
        else
            binding.imgFavDetalle.setImageResource(R.drawable.ic_favorito_off)

        binding.btnVolver.setOnClickListener {
            finish()
        }
    }
}