package com.carlyadam.arquitecture.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.carlyadam.arquitecture.data.api.Result
import com.carlyadam.arquitecture.data.model.Book
import com.carlyadam.arquitecture.repo.BookRepository
import com.carlyadam.arquitecture.utilities.Coroutines
import kotlinx.coroutines.Job

class BookViewModel(private val bookRepository: BookRepository) : ViewModel() {

    private val _bookLiveData = MutableLiveData<List<Book>>()
    val bookLiveData: LiveData<List<Book>> get() = _bookLiveData
    private val _errorLiveData = MutableLiveData<String>()
    val errorLiveData: LiveData<String> get() = _errorLiveData
    private var bookJob: Job? = null

    fun getBook() {
        bookJob = Coroutines.io {
            when (val result = bookRepository.getBook()) {
                is Result.Success -> _bookLiveData.postValue(result.data)
                is Result.Error -> _errorLiveData.postValue(result.exception.message)
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        bookJob?.cancel()
    }
}