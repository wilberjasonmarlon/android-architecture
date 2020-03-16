package com.carlyadam.arquitecture.ui.activities

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.Observer
import com.carlyadam.arquitecture.R
import com.carlyadam.arquitecture.ui.BaseActivity
import com.carlyadam.arquitecture.utilities.Coroutines
import com.carlyadam.arquitecture.viewmodel.BookViewModel
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.ext.android.inject

class MainActivity : BaseActivity() {
    private val bookViewModel: BookViewModel by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bookViewModel.getBook()

        bookViewModel.bookLiveData.observe(this, Observer {
            Log.i("RESSSSS", it.toString())
            progressBar.visibility = View.GONE
        })
        bookViewModel.errorLiveData.observe(this, Observer {
            Log.i("RESSSSS", it.toString())
            progressBar.visibility = View.GONE
        })
    }

    }
