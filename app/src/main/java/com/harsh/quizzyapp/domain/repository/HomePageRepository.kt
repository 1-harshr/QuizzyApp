package com.harsh.quizzyapp.domain.repository

import com.harsh.quizzyapp.data.model.StudentHomePageDto

interface HomePageRepository {
    suspend fun getHomePageData(): Result<StudentHomePageDto>
}
