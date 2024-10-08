package com.example.valorantagents.ui.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding

abstract class BaseFragment<B: ViewBinding>: Fragment() {

    protected lateinit var binding: B

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = getFragmentViewBinding(inflater, container)
        return binding.root
    }

    abstract fun getFragmentViewBinding(inflater: LayoutInflater, container: ViewGroup?) : B

}