package com.hayde117.media3exoplayercompose.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.hayde117.media3exoplayercompose.data.MediaPlayerModel
import com.hayde117.media3exoplayercompose.media_player.CafiTechPlayerView
import java.net.URLDecoder
import java.nio.charset.StandardCharsets

@Composable
fun ScreenB(modifier: Modifier = Modifier, args: MediaPlayerModel, onNextButtonAction: () -> Unit) {

    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Headerrr", modifier = Modifier.clickable{
            onNextButtonAction()
        })

        val decodedUrl = URLDecoder.decode(args.mediaUrl, StandardCharsets.UTF_8.toString())

        CafiTechPlayerView(
            videoUrl = decodedUrl
        )

        Button(onClick = { onNextButtonAction() }, modifier = modifier.fillMaxWidth()) {
            Text("Button")
        }
    }
}