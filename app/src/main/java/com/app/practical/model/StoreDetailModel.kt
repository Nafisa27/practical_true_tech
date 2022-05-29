package com.app.practical.model


import com.google.gson.annotations.SerializedName

data class StoreDetailModel(
    @SerializedName("data")
    val `data`: List<Data>
) {
    data class Data(
        @SerializedName("categoria")
        val categoria: Categoria,
        @SerializedName("categoria_ecommerce")
        val categoriaEcommerce: CategoriaEcommerce,
        @SerializedName("codigo")
        val codigo: String,
        @SerializedName("codigoBarra")
        val codigoBarra: String,
        @SerializedName("comision")
        val comision: String,
        @SerializedName("descTipoComision")
        val descTipoComision: String,
        @SerializedName("descripcion")
        val descripcion: Any,
        @SerializedName("idmenu")
        val idmenu: String,
        @SerializedName("imagen")
        val imagen: String,
        @SerializedName("impuesto")
        val impuesto: Int,
        @SerializedName("impuestoAplicado")
        val impuestoAplicado: Boolean,
        @SerializedName("modificadores")
        val modificadores: List<Modificadore>,
        @SerializedName("nombre")
        val nombre: String,
        @SerializedName("permite_descuentos")
        val permiteDescuentos: Boolean,
        @SerializedName("precio_abierto")
        val precioAbierto: Boolean,
        @SerializedName("precioSugerido")
        val precioSugerido: String,
        @SerializedName("tipo")
        val tipo: String,
        @SerializedName("tipo_comision")
        val tipoComision: String,
        @SerializedName("tipo_desc")
        val tipoDesc: String
    ) {
        data class Categoria(
            @SerializedName("codigo")
            val codigo: String,
            @SerializedName("idcategoriamenu")
            val idcategoriamenu: String,
            @SerializedName("impuesto")
            val impuesto: String,
            @SerializedName("nombremenu")
            val nombremenu: String,
            @SerializedName("orden")
            val orden: String,
            @SerializedName("porcentaje")
            val porcentaje: String,
            @SerializedName("printers")
            val printers: List<Printer>
        ) {
            data class Printer(
                @SerializedName("cutPaper")
                val cutPaper: Boolean,
                @SerializedName("desc_printer")
                val descPrinter: String,
                @SerializedName("desc_tipo")
                val descTipo: String,
                @SerializedName("id_printer")
                val idPrinter: String,
                @SerializedName("idtipo")
                val idtipo: String,
                @SerializedName("ip")
                val ip: String,
                @SerializedName("isDouble")
                val isDouble: Boolean
            )
        }

        data class CategoriaEcommerce(
            @SerializedName("codigo")
            val codigo: String,
            @SerializedName("idcategoriamenu")
            val idcategoriamenu: String,
            @SerializedName("impuesto")
            val impuesto: String,
            @SerializedName("nombremenu")
            val nombremenu: String,
            @SerializedName("orden")
            val orden: String,
            @SerializedName("porcentaje")
            val porcentaje: String
        )

        data class Modificadore(
            @SerializedName("idmodificador")
            val idmodificador: String
        )
    }
}