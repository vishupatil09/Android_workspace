package com.example.baby_names

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Model {


    @Expose
    @SerializedName("id")
    var id = 0

    @Expose
    @SerializedName("name")
    var name: String? = null

    @Expose
    @SerializedName("gender")
    var gender: String? = null

    @Expose
    @SerializedName("rashi")
    var rashi: String? = null

    @Expose
    @SerializedName("meaning")
    var meaning: String? = null
    @Expose
    @SerializedName("religion")
    var reigion: String? = null



}
