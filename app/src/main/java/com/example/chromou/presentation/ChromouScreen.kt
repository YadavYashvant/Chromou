package com.example.chromou.presentation


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.chromou.R

@Composable
fun ChromouScreen(viewModel: ChromouViewmodel) {
    val themeState by viewModel.themeState.collectAsState()

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text(
            "Current Theme: ${themeState.themeStyle}",
            style = MaterialTheme.typography.headlineMedium
        )
        Slider(
            value = themeState.hue,
            onValueChange = { viewModel.updateHue(it) },
            valueRange = 0f..1f
        )
        Button(onClick = { viewModel.updateThemeStyle("dark") }) {
            Text("Set Dark Theme")
        }
        Button(onClick = { viewModel.updateThemeStyle("light") }) {
            Text("Set Light Theme")
        }
    }
}