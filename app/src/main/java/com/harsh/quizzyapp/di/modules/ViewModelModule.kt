package com.harsh.quizzyapp.di.modules

import com.harsh.quizzyapp.ui.viewmodel.ExampleViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { ExampleViewModel(get()) }
}