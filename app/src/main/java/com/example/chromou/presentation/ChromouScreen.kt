package com.example.chromou.presentation

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ChromouScreen(viewModel: ChromouViewmodel) {
    val themeState by viewModel.themeState.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = "Current Theme: ${themeState.themeStyle}",
            style = MaterialTheme.typography.headlineMedium
        )
        
        Text(
            text = "Hue Adjustment",
            style = MaterialTheme.typography.bodyLarge
        )
        
        Slider(
            value = themeState.hue,
            onValueChange = { viewModel.updateHue(it) },
            valueRange = 0f..1f,
            steps = 100
        )
        
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Button(
                onClick = { viewModel.updateThemeStyle("light") },
                modifier = Modifier.weight(1f)
            ) {
                Text("Light Theme")
            }
            
            Button(
                onClick = { viewModel.updateThemeStyle("dark") },
                modifier = Modifier.weight(1f)
            ) {
                Text("Dark Theme")
            }
        }
    }
}