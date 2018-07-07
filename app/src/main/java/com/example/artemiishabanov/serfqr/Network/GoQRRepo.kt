package com.example.artemiishabanov.serfqr.Network

import android.media.Image
import io.reactivex.Observable

class SearchRepository(val apiService: GoQRApiService) {

    fun read(image: Image): Observable<ReadResult> {
        return apiService.read(image = image)
    }

    fun create(data:String): Observable<Image> {
        return apiService.create(data = data)
    }

}