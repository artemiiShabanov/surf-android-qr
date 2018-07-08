package com.example.artemiishabanov.serfqr.Network

import android.media.Image
import io.reactivex.Observable
import okhttp3.ResponseBody
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface GoQRApiService {

    @GET("read-qr-code")
    fun read(@Query("file") image: Image): Observable<ReadResult> //вообще хз что тут за тип у картинки


    @GET("create-qr-code")
    fun create(@Query("data") data: String, @Query("size") size: String): Observable<ResponseBody>


    companion object Factory {
        fun create(): GoQRApiService {
            val retrofit = Retrofit.Builder()
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl("https://api.qrserver.com/v1/")
                    .build()

            return retrofit.create(GoQRApiService::class.java)
        }
    }

}