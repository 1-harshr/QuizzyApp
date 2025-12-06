package com.harsh.quizzyapp.data.remote

import com.harsh.quizzyapp.data.model.StudentHomePageDto
import retrofit2.http.GET

interface ExampleApiService {
    @GET("example/endpoint")
    suspend fun getExampleData(): StudentHomePageDto
}