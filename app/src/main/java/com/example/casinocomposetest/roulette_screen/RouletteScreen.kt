package com.example.casinocomposetest.roulette_screen

import android.media.MediaPlayer
import androidx.compose.animation.core.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.casinocomposetest.R
import com.example.casinocomposetest.ui.theme.Red
import com.example.casinocomposetest.utils.ValueList
import kotlin.math.roundToInt

@Composable
fun RouletteScreen() {
//    val sound = MediaPlayer.create(LocalContext.current, R.raw.sound)

    var rotationValue by remember {
        mutableStateOf(0f)
    }

    var number by remember {
        mutableStateOf(0)
    }

    var enabled by remember { mutableStateOf(true) }

    val animNumber: Int by animateIntAsState(
        targetValue = number,
        animationSpec = tween(),
    )

    val angle: Float by animateFloatAsState(
        targetValue = rotationValue,
        animationSpec = tween(durationMillis = 2000),
        finishedListener = {
//            sound.stop()
            val index = (360f - (it % 360)) / (360f / 37)
            number = ValueList.list[index.roundToInt()]
            enabled = true
        },
    )

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
                .wrapContentHeight()
                .wrapContentWidth(),
            text = animNumber.toString(),
            fontWeight = FontWeight.Bold,
            fontSize = 80.sp,
            color = Color.White
        )
        Box(
            modifier = Modifier
                .weight(1f)
                .fillMaxSize()
        ) {
            Image(
                painter = painterResource(id = R.drawable.roulette_rim),
                contentDescription = "Roulette",
                modifier = Modifier.fillMaxSize()
            )
            Image(
                painter = painterResource(id = R.drawable.roulette_center),
                contentDescription = "Roulette",
                modifier = Modifier
                    .fillMaxSize()
                    .rotate(angle)
            )
            Image(
                painter = painterResource(id = R.drawable.arrow_my),
                contentDescription = "Arrow",
                modifier = Modifier.fillMaxSize()
            )
        }
        Button(
            onClick = {
                enabled = false
                rotationValue = (720..1080).random().toFloat() + angle
//                sound.start()
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(95.dp)
                .padding(10.dp),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Red,
                disabledBackgroundColor = Red
            ),
            enabled = enabled
        ) {
            Text(
                text = "SPIN",
                color = Color.White,
                fontSize = 45.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}