package com.example.artemiishabanov.serfqr.image

import android.hardware.Camera

/** A safe way to get an instance of the Camera object.  */
fun getCameraInstance(): Camera? {
    return try {
        val camera = Camera.open() // attempt to get a Camera instance
        camera.setDisplayOrientation(90)
        camera
    } catch (e: Exception) {
        null// Camera is not available (in use or does not exist)
    }
}