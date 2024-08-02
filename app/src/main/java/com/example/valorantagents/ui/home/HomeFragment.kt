package com.example.valorantagents.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.valorantagents.R
import com.example.valorantagents.databinding.FragmentHomeBinding
import com.example.valorantagents.ui.base.BaseFragment


class HomeFragment : BaseFragment<FragmentHomeBinding>() {

    override fun getFragmentViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentHomeBinding {
        return FragmentHomeBinding.inflate(inflater, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        binding.txtFragHome.text = "DEGISTIRILDI BINDING CALISIYOR "

    }

}