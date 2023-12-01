package com.example.apexfurniture.Apiclient

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiClient
{
    companion object {

        var BASE_URL="https://botched-headset.000webhostapp.com/API/"
        var retrofit: Retrofit? = null
        fun getapiclient(): Retrofit? {

            if (retrofit == null) {
                retrofit = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }
            return  retrofit
        }
    }
}