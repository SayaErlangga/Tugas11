package com.example.tugas11.model

import com.google.gson.annotations.SerializedName

data class DataMaps(
    @SerializedName("displayName")
    val displayName: String,

    @SerializedName("narrativeDescription")
    val description: String?
)
