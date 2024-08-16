package com.example.valorantagents.util

import android.view.View
import android.widget.ProgressBar

fun ProgressBar.visibleProgressBar(isVisible:Boolean){
    visibility = if (isVisible) View.VISIBLE else View.GONE
}