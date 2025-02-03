package com.example.chromou

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.chromou.presentation.ChromouScreen
import com.example.chromou.presentation.ChromouViewmodel
import com.example.chromou.ui.theme.ChromouTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewModel : ChromouViewmodel by viewModels()
        enableEdgeToEdge()
        setContent {
//            val viewModel: ChromouViewmodel = hiltViewModel()
            val themeState by viewModel.themeState.collectAsState()

            ChromouTheme(themePreferences = themeState) {
                ChromouScreen(viewModel)
            }
        }
    }
}