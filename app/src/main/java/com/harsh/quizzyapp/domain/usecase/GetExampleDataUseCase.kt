package com.harsh.quizzyapp.domain.usecase

import com.harsh.quizzyapp.domain.repository.ExampleRepository

class GetExampleDataUseCase(private val repository: ExampleRepository) {
    suspend operator fun invoke(): String {
        return repository.getData()
    }
}