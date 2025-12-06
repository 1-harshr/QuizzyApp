package com.harsh.quizzyapp.data.remote

import com.harsh.quizzyapp.data.model.ExampleDto
import retrofit2.http.GET

interface ExampleApiService {
    @GET("example/endpoint")
    suspend fun getExampleData(): ExampleDto
}