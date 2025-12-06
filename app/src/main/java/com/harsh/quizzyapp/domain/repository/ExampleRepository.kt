package com.harsh.quizzyapp.domain.repository

interface ExampleRepository {
    suspend fun getData(): String
}