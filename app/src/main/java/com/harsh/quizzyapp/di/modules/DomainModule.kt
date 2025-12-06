package com.harsh.quizzyapp.di.modules

import com.harsh.quizzyapp.domain.usecase.GetExampleDataUseCase
import com.harsh.quizzyapp.domain.usecase.GetHomePageDataUseCase
import com.harsh.quizzyapp.domain.usecase.LoginUseCase
import org.koin.dsl.module

val domainModule = module {
    factory { GetExampleDataUseCase(get()) }
    factory { LoginUseCase(get()) }
    factory { GetHomePageDataUseCase(get()) }
}