package com.example.chromou.domain

import com.example.chromou.data.ThemePreferencesRepository
import javax.inject.Inject

class UpdateThemeStyleUseCase @Inject constructor(private val repository: ThemePreferencesRepository) {
    suspend operator fun invoke(style: String) = repository.updateThemeStyle(style)
}
