package com.harsh.quizzyapp

import android.app.Application
import com.harsh.quizzyapp.di.koinModules
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class QuizzyApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@QuizzyApplication)
            modules(koinModules)
        }
    }
}