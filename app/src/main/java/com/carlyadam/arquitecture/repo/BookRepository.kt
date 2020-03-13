package com.carlyadam.arquitecture.repo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.carlyadam.arquitecture.data.ApiService
import com.carlyadam.arquitecture.data.model.BookInterceptor
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class BookRepository(private val apiService: ApiService) {

    private val _bookLiveData = MutableLiveData<BookInterceptor>()
    val bookLiveData: LiveData<BookInterceptor> = _bookLiveData

    suspend fun getBook(): LiveData<BookInterceptor> {
        return withContext(Dispatchers.IO) {
            fetchBook()
        }
    }

    private suspend fun fetchBook(): LiveData<BookInterceptor> {
        _bookLiveData.value = BookInterceptor(
            loading = true
        )
        val response = apiService.getBook()
        if (response.isSuccessful) {
            _bookLiveData.value = BookInterceptor(
                loading = false,
                book = response.body()
            )
        } else {
            _bookLiveData.value = BookInterceptor(
                loading = false,
                book = response.errorBody()!!.string()
            )
        }

        return bookLiveData

    }
}