package com.example.artemiishabanov.serfqr.image

import android.content.ContentValues.TAG
import android.content.Context
import android.hardware.Camera
import android.util.Log
import android.view.SurfaceHolder
import android.view.SurfaceView
import java.io.IOException

class CameraPreview(val camera: Camera, context: Context?) : SurfaceView(context), SurfaceHolder.Callback {

    @get:JvmName("getContext_")
    var holder = getHolder()

    init {
        holder.addCallback(this)

        // deprecated setting, but required on Android versions prior to 3.0
        holder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS)
    }

    override fun surfaceChanged(p0: SurfaceHolder?, p1: Int, p2: Int, p3: Int) {
        try {
            camera.setPreviewDisplay(holder)
            camera.startPreview()

        } catch (e: IOException) {
            Log.d(TAG, "Error setting camera preview: " + e.toString())
        }
    }

    override fun surfaceDestroyed(p0: SurfaceHolder?) {
        //empty now
    }

    override fun surfaceCreated(p0: SurfaceHolder?) {

        if (holder.surface == null) {
            // preview surface does not exist
            return
        }

        // stop preview before making changes
        try {
            camera.stopPreview()
        } catch (e: Exception) {
            // ignore: tried to stop a non-existent preview
        }


        // set preview size and make any resize, rotate or
        // reformatting changes here

        // start preview with new settings
        try {
            camera.setPreviewDisplay(holder)
            camera.startPreview()

        } catch (e: Exception) {
            Log.d(TAG, "Error starting camera preview: " + e.message)
        }

    }

}