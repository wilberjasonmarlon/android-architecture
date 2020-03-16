package com.carlyadam.arquitecture.ui.activities

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.carlyadam.arquitecture.R
import com.carlyadam.arquitecture.data.model.Book
import com.carlyadam.arquitecture.ui.BaseActivity
import com.carlyadam.arquitecture.ui.adapter.BookAdapter
import com.carlyadam.arquitecture.viewmodel.BookViewModel
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.ext.android.inject

class MainActivity : BaseActivity() {
    private val bookViewModel: BookViewModel by inject()
    private lateinit var bookAdapter: BookAdapter
    private var bookList = ArrayList<Book>()


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

    private fun initRecyclerView() {
        bookAdapter = BookAdapter(bookList, this)
        recyclerViewBook.layoutManager = LinearLayoutManager(this)
        recyclerViewBook.adapter = bookAdapter

    }

}
