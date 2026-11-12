package com.example.actividadruta

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Ruta(
    val titulo: String
    , val dificultad: String
    ,val minutos: Int
    ,val imagen: Int
    , var es_favorito: Boolean
    , val descripcion: String
): Parcelable
