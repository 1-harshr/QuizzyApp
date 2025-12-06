package com.harsh.quizzyapp.di.modules

import com.harsh.quizzyapp.domain.usecase.GetExampleDataUseCase
import org.koin.dsl.module

val domainModule = module {
    factory { GetExampleDataUseCase(get()) }
}