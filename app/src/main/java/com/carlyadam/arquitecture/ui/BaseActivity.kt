package com.carlyadam.arquitecture.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.carlyadam.arquitecture.R

class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
