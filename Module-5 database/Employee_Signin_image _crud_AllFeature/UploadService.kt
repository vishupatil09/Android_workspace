package com.example.employee

import okhttp3.MultipartBody
import okhttp3.RequestBody
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part

interface UploadService
{

    @Multipart
    @POST("uploaddata.php")
    suspend fun uploadImage(
        @Part image:MultipartBody.Part,
        @Part("emp_name") emp_name: RequestBody?,
        @Part("emp_mobile") emp_mobile: RequestBody?,
        @Part("emp_email") emp_email: RequestBody?,
        @Part("emp_pass") emp_pass: RequestBody?,


        ):ResponseBody
    @FormUrlEncoded
    @POST("employeelogin.php")
    fun loginform(
        @Field("emp_mobile") emp_mobile:String,
        @Field("emp_pass")  emp_pass:String,

        ) : Call<Void>

    @GET("employeeview.php")
    fun getdata() : Call<List<Model>>


    @FormUrlEncoded
    @POST("employeeupdate.php")
    fun updatedata(
        @Field("id") id :Int,
        @Field("emp_name") emp_name:String,
        @Field("emp_mobile") emp_mobile:String,
        @Field("emp_email")  emp_email:String,
        @Field("emp_pass")  emp_pass:String,

        ) : Call<Void>

    @FormUrlEncoded
    @POST("employeedelet.php")
    fun deletedata(@Field("id") id: Int): Call<Void>?

}