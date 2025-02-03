package com.example.chromou.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.chromou.data.ThemePreferences
import com.example.chromou.domain.GetThemePreferencesUseCase
import com.example.chromou.domain.UpdateThemeStyleUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ChromouViewmodel @Inject constructor(
    private val getThemePreferences: GetThemePreferencesUseCase,
    private val updateThemeStyle: UpdateThemeStyleUseCase
) : ViewModel() {

    private val _themeState = MutableStateFlow(ThemePreferences("default", 0.5f))
    val themeState: StateFlow<ThemePreferences> = _themeState

    init {
        viewModelScope.launch {
            getThemePreferences().collect { preferences ->
                _themeState.value = preferences
            }
        }
    }

    fun updateThemeStyle(style: String) {
        viewModelScope.launch {
            updateThemeStyle(style)
            _themeState.value = _themeState.value.copy(themeStyle = style)
        }
    }

    fun updateHue(hue: Float) {
        viewModelScope.launch {
            updateHue(hue)
            _themeState.value = _themeState.value.copy(hue = hue)
        }
    }
}