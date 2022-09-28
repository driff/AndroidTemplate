package com.driff.android.module_template.presentation.welcome

import androidx.lifecycle.*
import com.driff.android.module_template.domain.usecase.ModuleTemplateUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.launch
import javax.inject.Inject

const val WELCOME_MESSAGE = "WELCOME_MESSAGE"

@OptIn(ExperimentalCoroutinesApi::class)
@HiltViewModel
class WelcomeVM @Inject constructor(
    private val useCase: ModuleTemplateUseCase,
    private val savedStateHandle: SavedStateHandle,
    ): ViewModel() {

    val welcomeMessageState = savedStateHandle.getStateFlow(WELCOME_MESSAGE, "")
        .flatMapLatest { flowOf(useCase()) }

    fun fetchWelcomeMessage() = viewModelScope.launch {
        savedStateHandle[WELCOME_MESSAGE] = useCase()
        return@launch
    }



}