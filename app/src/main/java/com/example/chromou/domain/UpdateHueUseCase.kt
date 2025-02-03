package com.example.chromou.domain

import com.example.chromou.data.ThemePreferencesRepository
import javax.inject.Inject

class UpdateHueUseCase @Inject constructor(private val repository: ThemePreferencesRepository) {
    suspend operator fun invoke(hue: Float) = repository.updateHue(hue)
}