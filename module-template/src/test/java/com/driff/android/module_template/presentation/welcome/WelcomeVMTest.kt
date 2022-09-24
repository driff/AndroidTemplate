package com.driff.android.module_template.presentation.welcome

import androidx.lifecycle.SavedStateHandle
import com.driff.android.module_template.data.repository.TemplateRepository
import com.driff.android.module_template.data.repository.TemplateRepositoryImp
import com.driff.android.module_template.domain.usecase.ModuleTemplateUseCase
import com.driff.android.module_template.domain.usecase.TemplateUseCase
import io.mockk.coVerify
import io.mockk.spyk
import kotlinx.coroutines.*
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
    private val mainThreadSurrogate = newSingleThreadContext("UI thread")

    private lateinit var viewmodel: WelcomeVM
    private val repository: TemplateRepository = TemplateRepositoryImp()
    private val useCase: TemplateUseCase<Any?, String> = spyk(ModuleTemplateUseCase(repository))
    private val stateHandler: SavedStateHandle = SavedStateHandle(mutableMapOf())

    @Before
    fun setUp() {
        Dispatchers.setMain(mainThreadSurrogate)
        viewmodel = WelcomeVM(useCase, stateHandler)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain() // reset the main dispatcher to the original Main dispatcher
        mainThreadSurrogate.close()
    }

    @Test
    fun `GIVEN viewmodel instance WHEN fetchWelcomeMessage is invoked THEN it should fetch it from ModuleTemplateUseCase`() = runTest {
        viewmodel.fetchWelcomeMessage()
        coVerify { useCase(any()) }
    }

    @Test
    fun `GIVEN viewmodel instance WHEN fetchWelcomeMessage is invoked THEN message should be added to SavedStateHandler with WELCOME_MESSAGE key`() = runTest {
        val asyncJob = async {  viewmodel.fetchWelcomeMessage() }
        val response: String = asyncJob.await().let { stateHandler[WELCOME_MESSAGE]?: "" }
        assertEquals(repository.getMessageToDisplay(), response)
    }

}