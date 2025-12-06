package com.harsh.quizzyapp.data.repository

import com.harsh.quizzyapp.domain.repository.LoginRepository

class LoginRepositoryImpl : LoginRepository {
    override suspend fun login(schoolId: String, studentId: String): Result<Unit> {
        return try {
            if (schoolId.isNotBlank() && studentId.isNotBlank()) {
                Result.success(Unit)
            } else {
                Result.failure(Exception("School ID and Student ID are required"))
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}
