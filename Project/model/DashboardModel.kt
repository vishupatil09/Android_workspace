package com.example.apexfurniture.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class DashboardModel {

    @Expose
    @SerializedName("id")
    var id = 0

    @Expose
    @SerializedName("p_type")
    var p_type: String? = null

    @Expose
    @SerializedName("img")
    var img: String? = null
}