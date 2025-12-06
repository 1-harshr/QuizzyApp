package com.harsh.quizzyapp.di.modules

import com.harsh.quizzyapp.ui.viewmodel.ExampleViewModel
import com.harsh.quizzyapp.ui.viewmodel.HomePageViewModel
import com.harsh.quizzyapp.ui.viewmodel.LoginViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { ExampleViewModel(get()) }
    viewModel { LoginViewModel(get()) }
    viewModel { HomePageViewModel(get()) }
}