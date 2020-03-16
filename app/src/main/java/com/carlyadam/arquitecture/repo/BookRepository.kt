package com.carlyadam.arquitecture.repo

import com.carlyadam.arquitecture.data.api.ApiService
import com.carlyadam.arquitecture.data.api.Result
import com.carlyadam.arquitecture.data.api.safeApiCall
import com.carlyadam.arquitecture.data.model.Book
import java.io.IOException

class BookRepository(private val apiService: ApiService) {

    suspend fun getBook() = safeApiCall(
        call = { fetchBook() },
        errorMessage = "Error occurred"
    )

    private suspend fun fetchBook(): Result<Book> {
        val response = apiService.getBook()
        if (response.isSuccessful)
            return Result.Success(response.body()!!)
        return Result.Error(IOException("Error occurred during fetching books!"))
    }
}