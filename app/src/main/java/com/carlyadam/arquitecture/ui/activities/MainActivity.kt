package com.carlyadam.arquitecture.ui.activities

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.carlyadam.arquitecture.data.model.Book
import com.carlyadam.arquitecture.databinding.ActivityMainBinding
import com.carlyadam.arquitecture.ui.BaseActivity
import com.carlyadam.arquitecture.ui.adapter.BookAdapter
import com.carlyadam.arquitecture.viewmodel.BookViewModel
import org.koin.android.ext.android.inject

class MainActivity : BaseActivity() {
    private val bookViewModel: BookViewModel by inject()
    private lateinit var bookAdapter: BookAdapter
    private var bookList = ArrayList<Book>()
    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initRecyclerView()
        bookViewModel.getBook()

        bookViewModel.bookLiveData.observe(this, Observer {
            binding.progressBar.visibility = View.GONE
            bookList.addAll(it)
            bookAdapter.submitList(bookList)
        })
        bookViewModel.errorLiveData.observe(this, Observer {
            binding.progressBar.visibility = View.GONE
            showToast(it)
        })
        binding.button.setOnClickListener {
            bookViewModel.getBook()
        }
    }

    private fun initRecyclerView() {
        bookAdapter = BookAdapter(bookList, this)
        binding.recyclerViewBook.layoutManager = LinearLayoutManager(this)
        binding.recyclerViewBook.adapter = bookAdapter

    }

}
