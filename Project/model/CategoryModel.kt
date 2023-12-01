package com.example.apexfurniture.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class CategoryModel {
    @Expose
    @SerializedName("id")
    var id = 0

    @Expose
    @SerializedName("name")
    var name: String? = null


    @Expose
    @SerializedName("img")
    var img: String? = null

    @Expose
    @SerializedName("discription")
    var description: String? = null


    @Expose
    @SerializedName("price")
    var price: String? = null
}