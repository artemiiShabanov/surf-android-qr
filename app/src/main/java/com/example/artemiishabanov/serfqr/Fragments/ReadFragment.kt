package com.example.artemiishabanov.serfqr.Fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.artemiishabanov.serfqr.R

class ReadFragment: Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val rootView = inflater.inflate(R.layout.fragment_read, container, false)

        return rootView
    }

    companion object {
        fun newInstance(): ReadFragment {
            return ReadFragment()
        }
    }

}