package com.driff.android.module_template.domain.usecase

import com.driff.android.module_template.data.repository.TemplateRepository
import javax.inject.Inject

class ModuleTemplateUseCase @Inject constructor(private val repository: TemplateRepository): TemplateUseCase<Any?, String> {

    override suspend fun invoke(input: Any?): String {
        return repository.getMessageToDisplay()
    }


}