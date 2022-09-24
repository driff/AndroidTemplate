package com.driff.android.module_template.data.repository

import javax.inject.Inject

class TemplateRepositoryImp @Inject constructor(): TemplateRepository {
    override suspend fun getMessageToDisplay(): String = "Hello Template World"
}