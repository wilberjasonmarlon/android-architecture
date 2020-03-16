package com.carlyadam.arquitecture.repo

import android.content.Context
import com.carlyadam.arquitecture.R
import com.carlyadam.arquitecture.data.api.ApiService
import com.carlyadam.arquitecture.data.api.Result
import com.carlyadam.arquitecture.data.api.safeApiCall
import com.carlyadam.arquitecture.data.model.Book
import java.io.IOException

class BookRepository(private val apiService: ApiService, private val context: Context) {

    suspend fun getBook() = safeApiCall(
        call = { fetchBook() },
        errorMessage = context.getString(R.string.no_connection)
    )

    private suspend fun fetchBook(): Result<List<Book>> {
        val response = apiService.getBook()
        if (response.code() == 401)
            return Result.UnAuthorized(context.getString(R.string.unauthorized))
        else if (response.isSuccessful)
            return Result.Success(response.body()!!)
        return Result.Error(IOException(context.getString(R.string.no_connection)))
    }
}