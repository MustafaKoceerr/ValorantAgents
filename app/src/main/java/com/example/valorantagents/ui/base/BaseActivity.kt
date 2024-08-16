package com.example.valorantagents.ui.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding

abstract class BaseActivity<B: ViewBinding> :AppCompatActivity(){
    protected lateinit var binding: B

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = getActivityViewBinding(layoutInflater)
        setContentView(binding.root)

    }

    abstract fun getActivityViewBinding(inflater: LayoutInflater) : B

}