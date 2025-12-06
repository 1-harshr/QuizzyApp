package com.harsh.quizzyapp.data.repository

import com.harsh.quizzyapp.domain.repository.ExampleRepository

class ExampleRepositoryImpl : ExampleRepository {
    override suspend fun getData(): String {
        return "Example Data"
    }
}