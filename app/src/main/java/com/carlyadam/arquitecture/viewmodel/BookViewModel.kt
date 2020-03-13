package com.carlyadam.arquitecture.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.carlyadam.arquitecture.data.model.BookInterceptor
import com.carlyadam.arquitecture.repo.BookRepository

class BookViewModel(private val bookRepository: BookRepository) : ViewModel() {

    suspend fun getBook(): LiveData<BookInterceptor> {
        return bookRepository.getBook()
    }
}