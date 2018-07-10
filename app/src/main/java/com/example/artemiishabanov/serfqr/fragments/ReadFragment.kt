package com.example.artemiishabanov.serfqr.fragments

import android.content.Context
import android.graphics.BitmapFactory
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.hardware.Camera.PictureCallback
import android.opengl.Visibility
import android.view.View
import android.view.ViewGroup
import com.example.artemiishabanov.serfqr.network.GoQRRepo
import com.example.artemiishabanov.serfqr.R
import kotlinx.android.synthetic.main.fragment_read.view.*
import com.example.artemiishabanov.serfqr.image.CameraPreview
import com.example.artemiishabanov.serfqr.image.getCameraInstance
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit


class ReadFragment: Fragment() {

    val repo = GoQRRepo

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val rootView = inflater.inflate(R.layout.fragment_read, container, false)

        val camera = getCameraInstance()!!
        val cameraView = CameraPreview(camera, activity)
        rootView.frameLayout.addView(cameraView)


        Observable.interval(1, TimeUnit.SECONDS)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe({
                    camera.takePicture(null, null, { data, _ ->
                        repo.read(data)
                                .observeOn(AndroidSchedulers.mainThread())
                                .subscribeOn(Schedulers.io())
                                .subscribe({ result ->
                                    rootView.textView.visibility = View.VISIBLE
                                    rootView.textView.text = result.toString()
                                }, { error ->
                                    rootView.textView.visibility = View.VISIBLE
                                    rootView.textView.text = "error"
                                    error.printStackTrace()
                                })
                    })
                })

        return rootView
    }

    companion object {
        fun newInstance(): ReadFragment {
            return ReadFragment()
        }
    }



}