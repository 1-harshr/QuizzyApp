package com.harsh.quizzyapp.domain.usecase

import com.harsh.quizzyapp.data.model.StudentHomePageDto
import com.harsh.quizzyapp.domain.repository.HomePageRepository

class GetHomePageDataUseCase(private val repository: HomePageRepository) {
    suspend operator fun invoke(): Result<StudentHomePageDto> {
        return repository.getHomePageData()
    }
}
