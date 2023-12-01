package com.example.apexfurniture.ApiInterface

import com.example.apexfurniture.model.CartModel
import com.example.apexfurniture.model.CategoryModel
import com.example.apexfurniture.model.DashboardModel
import com.example.apexfurniture.model.RegisterModel
import com.example.apexfurniture.model.WishlistModel
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiInterface {
    //Register
    @FormUrlEncoded
    @POST("registration.php")
    fun registerdetail(
        @Field("name") name: String?,
        @Field("email") email: String?,
        @Field("mobile") mobile: String?,
        @Field("password") password: String?,
    ): Call<Void>

    //Login
    @FormUrlEncoded
    @POST("login.php")
    fun logindata(
        @Field("mobile") mobile: String?,
        @Field("password") password: String?
    ): Call<RegisterModel>

    //gift_category_view_dashboard

    @GET("dashboard_view.php")
    fun dashboard_viewdata() :Call<List<DashboardModel>>

    @GET("living_view.php")
    fun living_view() :Call<List<CategoryModel>>


    @GET("dinning_view.php")
    fun dining_view() :Call<List<CategoryModel>>

    @GET("bedroom_view.php")
    fun bedroom_view() :Call<List<CategoryModel>>

    @GET("homeoffice_view.php")
    fun office_view() :Call<List<CategoryModel>>

    @GET("outdoor_view.php")
    fun outdoor_view() :Call<List<CategoryModel>>

    @GET("kids_view.php")
    fun kids_view() :Call<List<CategoryModel>>


    @GET("accent_view.php")
    fun accent_view() :Call<List<CategoryModel>>

    @GET("storage_view.php")
    fun storage_view() :Call<List<CategoryModel>>


    @GET("bathroom_view.php")
    fun bathroom_view() :Call<List<CategoryModel>>

    @GET("entrylevel_view.php")
    fun entry_view() :Call<List<CategoryModel>>


    @GET("antique_view.php")
    fun antique_view() :Call<List<CategoryModel>>


    @FormUrlEncoded
    @POST("wishlistinsert.php")
    fun addtowishlist(
        @Field("name")name: String?,
        @Field("discription") description: String?,
        @Field("price") price:String?,
        @Field("img") img: String?,
        @Field("mobile") mobile: String?,
    ): Call<Void>

    @FormUrlEncoded
    @POST("viewwishlist.php")
    fun wishlistViewData(
        @Field("mobile") mobile: String?,
    ): Call<List<WishlistModel>>

    @FormUrlEncoded
    @POST("deletewishlist.php")
    fun deleteWishList(
        @Field("id") id: Int
    ): Call<Void>

    @FormUrlEncoded
    @POST("cartinsert.php")
    fun addtoCart(
        @Field("name")name: String?,
        @Field("discription")description: String?,
        @Field("price") price:String?,
        @Field("img") img: String?,
        @Field("mobile") mobile: String?,
    ): Call<Void>

    @FormUrlEncoded
    @POST("viewcart.php")
    fun cartViewData(
        @Field("mobile") mobile: String?,
    ): Call<List<CartModel>>

    @FormUrlEncoded
    @POST("deletecart.php")
    fun deleteCart(
        @Field("id") id: Int
    ): Call<Void>

}