package com.harsh.quizzyapp.data.repository

import com.harsh.quizzyapp.data.model.StudentHomePageDto
import com.harsh.quizzyapp.domain.repository.HomePageRepository

class HomePageRepositoryImpl : HomePageRepository {
    override suspend fun getHomePageData(): Result<StudentHomePageDto> {
        return try {
            Result.success(StudentHomePageDto.studentHomePageDto)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}
