package com.example.casinocomposetest

import android.content.pm.ActivityInfo
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import com.example.casinocomposetest.roulette_screen.RouletteScreen
import com.example.casinocomposetest.ui.theme.CasinoCompiseTestTheme
import com.example.casinocomposetest.ui.theme.GreenBg

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CasinoCompiseTestTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = GreenBg
                ) {
                    RouletteScreen()
                }
            }
        }
        this.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
    }
}