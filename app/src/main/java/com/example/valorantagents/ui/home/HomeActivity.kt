package com.example.valorantagents.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import androidx.activity.enableEdgeToEdge
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.valorantagents.R
import com.example.valorantagents.databinding.ActivityHomeBinding
import com.example.valorantagents.ui.base.BaseActivity

class HomeActivity : BaseActivity<ActivityHomeBinding>() {

    //    private lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState) // base activity'ye gidiyor
        initOnCreate()
//        binding = ActivityHomeBinding.inflate(layoutInflater)
//        val view = binding.root
//        setContentView(view)
//        setContentView(R.layout.activity_home)
        /**
         * Base activity ile yapıldı, binding ile bağlanmasına gerek yok.
         */

    }

    private fun initOnCreate(){
        enableEdgeToEdge()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(
                systemBars.left,
                systemBars.top,
                systemBars.right,
                systemBars.bottom
            )
            insets
        }
    }

    override fun getActivityViewBinding(inflater: LayoutInflater): ActivityHomeBinding {
        return ActivityHomeBinding.inflate(inflater)
    }

}