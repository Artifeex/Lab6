package com.example.lab6.fourth.network

import retrofit2.Retrofit
import retrofit2.converter.simplexml.SimpleXmlConverterFactory

object ApiFactory {

    private const val BASE_URL = "https://www.cbr.ru/scripts/"

    private val retrofit = Retrofit.Builder()
        .addConverterFactory(SimpleXmlConverterFactory.create())
        .baseUrl(BASE_URL)
        .build()

    val service = retrofit.create(ApiService::class.java)
}