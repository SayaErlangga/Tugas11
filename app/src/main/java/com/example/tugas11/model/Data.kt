package com.example.tugas11.model

import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("displayName")
    val displayName: String,

    @SerializedName("description")
    val description: String
)
