package com.example.chromou.ui.theme

import android.os.Build
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import com.example.chromou.data.ThemePreferences



@Composable
fun ChromouTheme(
    themePreferences: ThemePreferences,
    content: @Composable () -> Unit
) {
    val context = LocalContext.current
    val colorScheme = when {
        Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            when (themePreferences.themeStyle) {
                "dark" -> dynamicDarkColorScheme(context)
                "light" -> dynamicLightColorScheme(context)
                else -> dynamicLightColorScheme(context)
            }
        }
        else -> {
            // Fallback for devices below Android 12
            when (themePreferences.themeStyle) {
                "dark" -> darkColorScheme()
                else -> lightColorScheme()
            }
        }
    }

    MaterialTheme(
        colorScheme = colorScheme.copy(
            primary = colorScheme.primary.copy(alpha = themePreferences.hue)
        ),
        typography = Typography,
        content = content
    )
}