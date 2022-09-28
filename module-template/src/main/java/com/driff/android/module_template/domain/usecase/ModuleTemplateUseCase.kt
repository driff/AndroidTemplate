package com.driff.android.module_template.domain.usecase

import com.driff.android.module_template.data.repository.TemplateRepository
import javax.inject.Inject

class ModuleTemplateUseCase @Inject constructor(private val repository: TemplateRepository) {

    suspend operator fun invoke(): String {
        return repository.getMessageToDisplay()
    }

}