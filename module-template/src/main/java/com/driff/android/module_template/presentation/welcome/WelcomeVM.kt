package com.driff.android.module_template.presentation.welcome

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.driff.android.module_template.domain.usecase.TemplateUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

const val WELCOME_MESSAGE = "WELCOME_MESSAGE"

@HiltViewModel
class WelcomeVM @Inject constructor(
    private val useCase: TemplateUseCase<Any?, String>,
    private val savedStateHandle: SavedStateHandle,
    ): ViewModel() {



    fun fetchWelcomeMessage() = viewModelScope.launch {
        val message = useCase(null)
        savedStateHandle.set(WELCOME_MESSAGE, message)
    }



}