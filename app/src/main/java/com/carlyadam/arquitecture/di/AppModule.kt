package com.carlyadam.arquitecture.di

import com.carlyadam.arquitecture.data.ApiService
import com.carlyadam.arquitecture.data.NetworkConnectionInterceptor
import com.carlyadam.arquitecture.repo.BookRepository
import com.carlyadam.arquitecture.viewmodel.BookViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

object AppModule {

    val webServiceModule = module {
        single { ApiService(get()) }
        single { NetworkConnectionInterceptor(get()) }
    }
    val bookModule = module {
        single { BookRepository(get()) }
        viewModel { BookViewModel(get()) }
    }
}