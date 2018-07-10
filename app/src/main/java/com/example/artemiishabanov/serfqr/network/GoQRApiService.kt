package com.example.artemiishabanov.serfqr.network

import io.reactivex.Observable
import okhttp3.MultipartBody
import okhttp3.RequestBody
import okhttp3.ResponseBody
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*

interface GoQRApiService {

    @Multipart
    @POST("read-qr-code")
    fun read(@Part("file") image: RequestBody): Observable<ReadResult>


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
