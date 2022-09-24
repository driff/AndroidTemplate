package com.driff.android.module_template.domain.usecase

interface TemplateUseCase<I, O> {

    suspend operator fun invoke(input: I): O

}