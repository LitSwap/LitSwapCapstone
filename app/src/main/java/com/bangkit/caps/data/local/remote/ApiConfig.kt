package com.bangkit.caps.data.local.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class ApiConfig {
    object RetrofitInstance {
        private const val BASE_URL = "https://litswap-project.et.r.appspot.com/"

        private val retrofit by lazy {
            Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }

        val ApiService: ApiService by lazy {
            retrofit.create(ApiService::class.java)
        }
    }
}