package com.harsh.quizzyapp.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.harsh.quizzyapp.domain.usecase.GetExampleDataUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ExampleViewModel(private val getExampleDataUseCase: GetExampleDataUseCase) : ViewModel() {

    private val _data = MutableStateFlow<String>("")
    val data: StateFlow<String> = _data

    fun loadData() {
        viewModelScope.launch {
            _data.value = getExampleDataUseCase()
        }
    }
}