package com.app.practical.network

import com.app.practical.model.StoreDetailModel
import com.app.practical.model.StoreModel
import com.app.practical.network.APIConstant.API_STORE
import com.app.practical.network.APIConstant.API_STORE_DETAIL
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header

interface ApiService {


    @GET(API_STORE)
    suspend fun getNewsList( @Header("APIKEY") apiKey : String): Response<StoreModel>
    @GET(API_STORE_DETAIL)
    suspend fun getStoreDetailList( @Header("APIKEY") apiKey : String): Response<StoreDetailModel>

}