package com.example.baby_names

import retrofit2.Call
import retrofit2.http.GET

interface Apiinterface {


    @GET("baby_view.php")
    fun viewnames() : Call<List<Model>>

}