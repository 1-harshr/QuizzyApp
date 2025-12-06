package com.harsh.quizzyapp.domain.usecase

import com.harsh.quizzyapp.domain.repository.LoginRepository

class LoginUseCase(private val repository: LoginRepository) {
    suspend operator fun invoke(schoolId: String, studentId: String): Result<Unit> {
        return repository.login(schoolId, studentId)
    }
}
