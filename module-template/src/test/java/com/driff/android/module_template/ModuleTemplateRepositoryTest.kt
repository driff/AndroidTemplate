package com.driff.android.module_template

import com.driff.android.module_template.data.repository.TemplateRepository
import com.driff.android.module_template.data.repository.TemplateRepositoryImp
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class ModuleTemplateRepositoryTest {

    lateinit var repository: TemplateRepository

    @Test
    fun `GIVEN a TemplateRepositoryImp WHEN getMessageToDisplay is invoked THEN it should return a non empty String`() = runTest {
        repository = TemplateRepositoryImp()
        val response = repository.getMessageToDisplay()
        assertTrue(response.isNotEmpty())
    }

    @Test
    fun `GIVEN a TemplateRepositoryImp WHEN getMessageToDisplay is invoked THEN it should return Hello Template World`() = runTest {
        repository = TemplateRepositoryImp()
        val response = repository.getMessageToDisplay()
        assertEquals("Hello Template World", response)
    }

}