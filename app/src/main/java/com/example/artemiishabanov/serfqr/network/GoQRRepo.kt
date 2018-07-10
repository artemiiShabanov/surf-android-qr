package com.example.artemiishabanov.serfqr.network

import android.graphics.Bitmap
import com.example.artemiishabanov.serfqr.image.responseBodyToImage
import io.reactivex.Observable
import okhttp3.MediaType
import okhttp3.MultipartBody
import okhttp3.RequestBody
import okhttp3.ResponseBody

object GoQRRepo {
    private val apiService = GoQRApiService.create()

    fun read(image: ByteArray): Observable<ReadResult> {
        return apiService.read(RequestBody.create(MediaType.parse("multipart/form-data"), image))
    }

    fun create(data: String): Observable<Bitmap> {
        return apiService.create(data, "400x400")
                .map({ responseBodyToImage(it)})
    }

}