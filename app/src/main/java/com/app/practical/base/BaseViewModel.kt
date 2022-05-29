package com.app.practical.base

import androidx.lifecycle.ViewModel
import com.app.practical.network.ApiService
import javax.inject.Inject

abstract class BaseViewModel : ViewModel() {
    @Inject
    lateinit var provideApiService: ApiService
}