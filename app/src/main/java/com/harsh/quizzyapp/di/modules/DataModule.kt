package com.harsh.quizzyapp.di.modules

import com.harsh.quizzyapp.data.repository.ExampleRepositoryImpl
import com.harsh.quizzyapp.data.repository.HomePageRepositoryImpl
import com.harsh.quizzyapp.data.repository.LoginRepositoryImpl
import com.harsh.quizzyapp.domain.repository.ExampleRepository
import com.harsh.quizzyapp.domain.repository.HomePageRepository
import com.harsh.quizzyapp.domain.repository.LoginRepository
import org.koin.dsl.module

val dataModule = module {
    single<ExampleRepository> { ExampleRepositoryImpl() }
    single<LoginRepository> { LoginRepositoryImpl() }
    single<HomePageRepository> { HomePageRepositoryImpl() }
}