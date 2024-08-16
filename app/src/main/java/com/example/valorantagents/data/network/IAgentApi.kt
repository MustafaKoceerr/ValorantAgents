package com.example.valorantagents.data.network

import com.example.valorantagents.data.network.model.Agent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface IAgentApi {
    companion object {
        // invoke -> MoviesApi() yazınca çalışacak fonksiyondur, özel bir keydir
        private val BASE_URL = "https://valorant-api.com/"

        operator fun invoke(): IAgentApi {
            return Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build()
                .create(IAgentApi::class.java)
        }
        // singleton yapısı sağlıyor
    }

    @GET("v1/agents")
    suspend fun getAgents(): Agent
}