package com.driff.android.module_template.domain.usecase

import com.driff.android.module_template.data.repository.TemplateRepository
import com.driff.android.module_template.data.repository.TemplateRepositoryImp
import io.mockk.coVerify
import io.mockk.spyk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class ModuleTemplateUseCaseTest {

    lateinit var useCase: ModuleTemplateUseCase
    private val repository: TemplateRepository = spyk(TemplateRepositoryImp())

    @Test
    fun `GIVEN a ModuleTemplateUseCase instance WHEN it is invoked with any parameter THEN it should return a non empty String`() =
        runTest {
            useCase = ModuleTemplateUseCase(repository)
            val response = useCase()
            assertTrue(response.isNotEmpty())
        }

    @Test
    fun `GIVEN a ModuleTemplateUseCase instance WHEN it is invoked with any parameter THEN it should call TemplateRepository`() =
        runTest {
            useCase = ModuleTemplateUseCase(repository)
            useCase()
            coVerify { repository.getMessageToDisplay() }
        }

    @Test
    fun `GIVEN a ModuleTemplateUseCase instance WHEN it is invoked with any parameter THEN it should return getMessageToDisplayResponse`() =
        runTest {
            useCase = ModuleTemplateUseCase(repository)
            val response = useCase()
            assertEquals(repository.getMessageToDisplay(), response)
        }
}