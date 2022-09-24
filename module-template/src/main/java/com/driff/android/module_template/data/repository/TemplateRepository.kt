package com.driff.android.module_template.data.repository

interface TemplateRepository {

    suspend fun getMessageToDisplay(): String

}