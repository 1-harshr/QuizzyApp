package com.harsh.quizzyapp.di

import com.harsh.quizzyapp.di.modules.appModule
import com.harsh.quizzyapp.di.modules.dataModule
import com.harsh.quizzyapp.di.modules.domainModule
import com.harsh.quizzyapp.di.modules.viewModelModule

val koinModules = listOf(
    appModule,
    dataModule,
    domainModule,
    viewModelModule
)