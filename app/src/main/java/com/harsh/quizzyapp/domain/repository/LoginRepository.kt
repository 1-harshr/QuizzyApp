package com.harsh.quizzyapp.domain.repository

interface LoginRepository {
    suspend fun login(schoolId: String, studentId: String): Result<Unit>
}
