package com.example.chromou.domain

import com.example.chromou.data.ThemePreferences
import com.example.chromou.data.ThemePreferencesRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetThemePreferencesUseCase @Inject constructor(private val repository: ThemePreferencesRepository) {
    operator fun invoke(): Flow<ThemePreferences> = repository.themePreferencesFlow
}