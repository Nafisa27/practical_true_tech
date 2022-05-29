package com.app.practical.network

object APIConstant {

    //http://sd2-hiring.herokuapp.com/api/users?offset=10&limit=10/
    const val BASE_URL = "https://newsapi.org/v2/"
    const val API_USERS = "top-headlines"
    const val API_STORE = "https://api.invupos.com/invuApiPos/index.php?r=configuraciones/franquicias"
    const val API_STORE_DETAIL= "https://api.invupos.com/invuApiPos/index.php?r=menu"
    const val PARAM_OFFSET = "offset"
    const val PARAM_LIMIT = "limit"

    const val STATUS_SUCCESS = 200
    const val STATUS_NOT_FOUND = 404
    const val STATUS_INTERNAL_SERVER_ERROR = 501
}