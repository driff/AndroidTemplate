package com.driff.android.module_template.presentation.welcome

import androidx.lifecycle.*
import com.driff.android.module_template.domain.usecase.TemplateUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.launch
import javax.inject.Inject

const val WELCOME_MESSAGE = "WELCOME_MESSAGE"

@HiltViewModel
class WelcomeVM @Inject constructor(
    private val useCase: TemplateUseCase<Any?, String>,
    private val savedStateHandle: SavedStateHandle,
    ): ViewModel() {

    val welcomeMessageState = savedStateHandle.getStateFlow(WELCOME_MESSAGE, "")
        .flatMapLatest { flowOf(useCase(null)) }

    fun fetchWelcomeMessage() = viewModelScope.launch {
        savedStateHandle[WELCOME_MESSAGE] = useCase(null)
        return@launch
    }



}