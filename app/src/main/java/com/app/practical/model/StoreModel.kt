package com.app.practical.model


import com.google.gson.annotations.SerializedName

data class StoreModel(
    @SerializedName("franquicias")
    val franquicias: List<Franquicia>
) {
    data class Franquicia(
        @SerializedName("APIKEY")
        val aPIKEY: String,
        @SerializedName("franquicia")
        val franquicia: String,
        @SerializedName("horaCierreLocal")
        val horaCierreLocal: String,
        @SerializedName("id_franquicia")
        val idFranquicia: String,
        @SerializedName("negocio")
        val negocio: String,
        @SerializedName("principal")
        val principal: Boolean,
        @SerializedName("tokenInvu")
        val tokenInvu: String
    )
}