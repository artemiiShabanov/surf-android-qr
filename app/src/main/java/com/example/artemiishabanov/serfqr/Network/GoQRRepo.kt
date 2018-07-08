package com.example.artemiishabanov.serfqr.Network

import android.media.Image
import io.reactivex.Observable
import okhttp3.ResponseBody

object GoQRRepo {
    private val apiService= GoQRApiService.create()

    fun read(image: Image): Observable<ReadResult> {
        //TODO: Image format
        return apiService.read(image = image)
    }

    fun create(data:String): Observable<ResponseBody> {
        //TODO: URL encoding
        return apiService.create(data = data, size = "400x400")
    }

}