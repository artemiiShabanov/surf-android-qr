package com.example.artemiishabanov.serfqr.Network

data class Symbol (
        val seq: Int,
        val data: String,
        val error: Any
)

data class ReadResult (
        val type: String,
        val symbol: List<Symbol>
)

