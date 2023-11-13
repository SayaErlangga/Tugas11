package com.example.tugas11.model

import com.google.gson.annotations.SerializedName

data class Maps(
    @SerializedName("data")
    val data: List<DataMaps>
)
