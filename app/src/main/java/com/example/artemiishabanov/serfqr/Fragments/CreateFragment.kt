package com.example.artemiishabanov.serfqr.Fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.artemiishabanov.serfqr.Image.responseBodyToImage
import com.example.artemiishabanov.serfqr.Network.GoQRRepo
import com.example.artemiishabanov.serfqr.R
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.fragment_create.view.*

class CreateFragment: Fragment() {

    val repo = GoQRRepo

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val rootView = inflater.inflate(R.layout.fragment_create, container, false)
        rootView.button.setOnClickListener{
            repo.create(rootView.textInputLayout.editText!!.text.toString())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribeOn(Schedulers.io())
                    .subscribe ({
                        result -> rootView.imageView.setImageBitmap(responseBodyToImage(result))
                    }, { error ->
                        error.printStackTrace()
                    })
        }

        return rootView
    }

    companion object {
        fun newInstance(): CreateFragment {
            return CreateFragment()
        }
    }

}