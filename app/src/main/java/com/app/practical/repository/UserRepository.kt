package com.app.practical.repository

import com.app.practical.model.StoreDetailModel
import com.app.practical.model.StoreModel
import com.app.practical.network.ApiService
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserRepository @Inject constructor(private val service: ApiService) {


    suspend fun getStoreList(): Response<StoreModel> {
        return service.getNewsList( "bd_suvlascentralpos")
    }

    suspend fun getStoreDetailList(apikey: String?): Response<StoreDetailModel> {
        return service.getStoreDetailList(apikey.toString())
    }

}