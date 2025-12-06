package com.harsh.quizzyapp.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.harsh.quizzyapp.common.DataWrapper
import com.harsh.quizzyapp.data.model.StudentHomePageDto
import com.harsh.quizzyapp.domain.usecase.GetHomePageDataUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class HomePageViewModel(
    private val getHomePageDataUseCase: GetHomePageDataUseCase
) : ViewModel() {

    private val _homePageData = MutableStateFlow<DataWrapper<StudentHomePageDto>>(DataWrapper.Loading())
    val homePageData: StateFlow<DataWrapper<StudentHomePageDto>> = _homePageData

    init {
        loadHomePageData()
    }

    private fun loadHomePageData() {
        viewModelScope.launch {
            _homePageData.update {
                DataWrapper.Loading()
            }
            getHomePageDataUseCase()
                .onSuccess { data ->
                    _homePageData.update {
                        DataWrapper.Success(data)
                    }
                }
                .onFailure { e ->
                    _homePageData.update {
                        DataWrapper.Error(e)
                    }
                }
        }
    }
}

