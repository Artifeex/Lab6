package com.example.lab6.fourth.network

import androidx.lifecycle.LiveData
import com.example.lab6.fourth.network.pojo.CoinsInfoDto
import retrofit2.http.GET

interface ApiService {

    @GET("XML_daily.asp")
    suspend fun getCoinInfo(): CoinsInfoDto

}