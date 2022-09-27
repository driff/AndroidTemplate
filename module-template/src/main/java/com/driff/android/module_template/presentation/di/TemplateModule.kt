package com.driff.android.module_template.presentation.di

import com.driff.android.module_template.data.repository.TemplateRepository
import com.driff.android.module_template.data.repository.TemplateRepositoryImp
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent

@Module
@InstallIn(ActivityRetainedComponent::class)
interface TemplateModule {

    @Binds
    fun templateRepositoryBinding(repositoryImp: TemplateRepositoryImp): TemplateRepository


}