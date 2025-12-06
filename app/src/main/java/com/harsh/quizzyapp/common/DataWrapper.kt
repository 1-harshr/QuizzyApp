package com.harsh.quizzyapp.common

sealed  class DataWrapper <T> {
    data class Success<T>(val data: T) : DataWrapper<T>()
    data class Error<T>(val throwable: Throwable) : DataWrapper<T>()
    data class Loading<T>(val isLoading: Boolean = true) : DataWrapper<T>()
}