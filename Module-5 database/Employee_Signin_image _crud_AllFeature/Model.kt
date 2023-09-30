package com.example.employee

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Model {
    @Expose
    @SerializedName("id")
    var id = 0

    @Expose
    @SerializedName("emp_name")
    var emp_name: String? = null

    @Expose
    @SerializedName("emp_mobile")
    var emp_mobile: String? = null

    @Expose
    @SerializedName("emp_email")
    var emp_email: String? = null

    @Expose
    @SerializedName("emp_pass")
    var emp_pass: String? = null
    @Expose
    @SerializedName("img")
    var img: String? = null

}

