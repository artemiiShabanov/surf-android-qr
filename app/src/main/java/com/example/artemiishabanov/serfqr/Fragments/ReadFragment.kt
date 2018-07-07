package com.example.artemiishabanov.serfqr.Fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.artemiishabanov.serfqr.R
import kotlinx.android.synthetic.main.fragment_main.view.*

class ReadFragment: Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val rootView = inflater.inflate(R.layout.fragment_main, container, false)
        rootView.section_label.text = getString(R.string.section_format, 0)
        return rootView
    }

    companion object {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        fun newInstance(): ReadFragment {
            val fragment = ReadFragment()
            val args = Bundle()
            fragment.arguments = args
            return fragment
        }
    }
}