package com.carlyadam.arquitecture.di

import com.carlyadam.arquitecture.data.api.ApiService
import com.carlyadam.arquitecture.repo.BookRepository
import com.carlyadam.arquitecture.viewmodel.BookViewModel
import mx.devbizne.bizne.utils.NetworkConnectionInterceptor
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

object AppModule {

    val webServiceModule = module {
        single { ApiService(get()) }
        single {
            NetworkConnectionInterceptor(
                get()
            )
        }
    }
    val bookModule = module {
        single { BookRepository(get()) }
        viewModel { BookViewModel(get()) }
    }
}