package com.driff.android.module_template.presentation.welcome

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.SavedStateHandle
import app.cash.turbine.test
import com.driff.android.module_template.data.repository.TemplateRepository
import com.driff.android.module_template.data.repository.TemplateRepositoryImp
import com.driff.android.module_template.domain.usecase.ModuleTemplateUseCase
import io.mockk.coVerify
import io.mockk.spyk
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@OptIn(DelicateCoroutinesApi::class, ExperimentalCoroutinesApi::class)
class WelcomeVMTest {

    @get:Rule
    var mainCoroutineRule = InstantTaskExecutorRule()

    private lateinit var viewmodel: WelcomeVM
    private val repository: TemplateRepository = TemplateRepositoryImp()
    private val stateMap = mutableMapOf<String, Any?>()
    private val useCase: ModuleTemplateUseCase = spyk(ModuleTemplateUseCase(repository))
    private val stateHandler: SavedStateHandle = SavedStateHandle(stateMap)

    @Before
    fun setUp() {
        Dispatchers.setMain(Dispatchers.Unconfined)
        viewmodel = WelcomeVM(useCase, stateHandler)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain() // reset the main dispatcher to the original Main dispatcher
    }

    @Test
    fun `GIVEN viewmodel instance WHEN fetchWelcomeMessage is invoked THEN it should fetch it from ModuleTemplateUseCase`() = runTest {
        viewmodel.fetchWelcomeMessage()
        coVerify { useCase.invoke(any()) }
    }

    @Test
    fun `GIVEN viewmodel instance WHEN fetchWelcomeMessage is invoked THEN message should be emitted through welcomeMessageState`() = runTest {
        val response = "Hello Template World"
        viewmodel.welcomeMessageState.test {
            assertEquals(response, awaitItem())
            cancelAndIgnoreRemainingEvents()
        }
    }

}