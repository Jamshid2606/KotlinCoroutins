package com.jama.kotlincoroutins.models

import android.location.Address
import com.google.gson.annotations.SerializedName

data class Geo (
    @SerializedName("lat")
    val lat: String?,
    @SerializedName("long")
    val long:String?,
)