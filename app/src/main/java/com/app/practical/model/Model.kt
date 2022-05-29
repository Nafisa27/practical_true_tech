package com.app.practical.model

data class Model(

    val name : String
){
    companion object {

        fun getData(): List<Model> {
            return (
                    listOf(
                        Model("chicken"),
                        Model("Pork"),
                        Model("Greek"),
                        Model("Beef"),
                        Model("Extras"),
                        Model("Cordero Yeero Pita"),
                        Model("Extra Guacamole"),
                        Model("Chicken Pita"),
                        ))
        }

    }
}