package com.harsh.quizzyapp.di.modules

import com.harsh.quizzyapp.data.repository.ExampleRepositoryImpl
import com.harsh.quizzyapp.domain.repository.ExampleRepository
import org.koin.dsl.module

val dataModule = module {
    single<ExampleRepository> { ExampleRepositoryImpl() }
}