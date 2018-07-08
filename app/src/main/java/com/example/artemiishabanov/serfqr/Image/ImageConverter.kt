package com.example.artemiishabanov.serfqr.Image

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import okhttp3.ResponseBody


fun responseBodyToImage(responseBody: ResponseBody): Bitmap? {
    print(responseBody)
    val stream = responseBody.byteStream()
    return BitmapFactory.decodeStream(stream)
}