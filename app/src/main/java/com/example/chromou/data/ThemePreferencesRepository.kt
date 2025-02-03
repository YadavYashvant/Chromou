package com.example.chromou.data

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.floatPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class ThemePreferencesRepository(private val dataStore: DataStore<Preferences>) {

    companion object {
        val THEME_STYLE = stringPreferencesKey("theme_style")
        val HUE = floatPreferencesKey("hue")
    }

    val themePreferencesFlow: Flow<ThemePreferences> = dataStore.data
        .map { preferences ->
            ThemePreferences(
                themeStyle = preferences[THEME_STYLE] ?: "default",
                hue = preferences[HUE] ?: 0.5f
            )
        }

    suspend fun updateThemeStyle(style: String) {
        dataStore.edit { preferences ->
            preferences[THEME_STYLE] = style
        }
    }

    suspend fun updateHue(hue: Float) {
        dataStore.edit { preferences ->
            preferences[HUE] = hue
        }
    }
}