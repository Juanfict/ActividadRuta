package com.example.actividadruta

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CustomAdapter(private val dataSet: MutableList<Ruta>
                    ,private val imgFavoritoClic:(Ruta)-> Unit
                    ,private val itemClic:(Ruta)-> Unit
                    ) :
    RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder)
     */
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imgRuta: ImageView
        val titulo: TextView
        val dificultad: TextView
        val minutos: TextView
        val imgFavorito: ImageView

        init {
            imgRuta = view.findViewById<ImageView>(R.id.imagenRuta)
            // Define click listener for the ViewHolder's View
            titulo = view.findViewById(R.id.tTitulo)
            dificultad = view.findViewById(R.id.tDificultad)
            minutos = view.findViewById(R.id.tMinutos)
            imgFavorito = view.findViewById<ImageView>(R.id.imagenFavorito)
        }
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.item_ruta, viewGroup, false)

        return ViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        viewHolder.imgRuta.setImageResource(dataSet[position].imagen)
        viewHolder.titulo.text = dataSet[position].titulo
        viewHolder.dificultad.text = dataSet[position].dificultad
        viewHolder.minutos.text = dataSet[position].minutos.toString() + " minutos"
        if(dataSet[position].es_favorito)
            viewHolder.imgFavorito.setImageResource(R.drawable.ic_favorito_on)
        else
            viewHolder.imgFavorito.setImageResource(R.drawable.ic_favorito_off)

        viewHolder.imgFavorito.setOnClickListener {
            dataSet[viewHolder.bindingAdapterPosition].es_favorito = !dataSet[viewHolder.bindingAdapterPosition].es_favorito
            notifyItemChanged(viewHolder.bindingAdapterPosition)
            imgFavoritoClic(dataSet[viewHolder.bindingAdapterPosition])
        }
        viewHolder.itemView.setOnClickListener { itemClic(dataSet[viewHolder.bindingAdapterPosition]) }

    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = dataSet.size

}