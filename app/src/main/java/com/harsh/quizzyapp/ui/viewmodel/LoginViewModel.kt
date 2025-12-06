package com.harsh.quizzyapp.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.harsh.quizzyapp.common.DataWrapper
import com.harsh.quizzyapp.domain.usecase.LoginUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class LoginViewModel(
    private val loginUseCase: LoginUseCase
) : ViewModel() {

    private val _schoolId = MutableStateFlow("")
    val schoolId: StateFlow<String> = _schoolId

    private val _studentId = MutableStateFlow("")
    val studentId: StateFlow<String> = _studentId

    private val _loginState = MutableStateFlow<DataWrapper<Unit>?>(null)
    val loginState: StateFlow<DataWrapper<Unit>?> = _loginState

    fun updateSchoolId(value: String) {
        _schoolId.value = value
    }

    fun updateStudentId(value: String) {
        _studentId.value = value
    }

    fun login(onSuccess: () -> Unit) {
        viewModelScope.launch {
            if (_schoolId.value.isNotBlank() && _studentId.value.isNotBlank()) {
                _loginState.update {
                    DataWrapper.Loading()
                }
                loginUseCase(_schoolId.value, _studentId.value)
                    .onSuccess {
                        _loginState.update {
                            DataWrapper.Success(Unit)
                        }
                        onSuccess()
                    }
                    .onFailure { e ->
                        _loginState.update {
                            DataWrapper.Error(e)
                        }
                    }
            }
        }
    }
}

