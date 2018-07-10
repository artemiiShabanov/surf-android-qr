package com.example.artemiishabanov.serfqr.network

import com.google.gson.annotations.SerializedName

data class Symbol(
        @SerializedName("seq") val seq: Int,
        @SerializedName("data") val data: String,
        @SerializedName("error") val error: Any
)

data class ReadResult(
        @SerializedName("type") val type: String,
        @SerializedName("symbol") val symbol: List<Symbol>
)

