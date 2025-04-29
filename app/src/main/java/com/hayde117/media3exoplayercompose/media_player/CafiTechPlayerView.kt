package com.hayde117.media3exoplayercompose.media_player

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.hayde117.media3exoplayercompose.ui.PlayerViewModel
import com.hayde117.media3exoplayercompose.util.PlayerError
import com.hayde117.media3exoplayercompose.util.PlayerMediaErrorUI

@Composable
fun CafiTechPlayerView(videoUrl: String, playerViewModel: PlayerViewModel = viewModel()) {

    val context = LocalContext.current
    val player by playerViewModel.playerState.collectAsState()
    val error by playerViewModel.errorState.collectAsState()

    LaunchedEffect(videoUrl) {
        playerViewModel.initializePlayer(context, videoUrl)
    }

    DisposableEffect(Unit) {
        onDispose {
            playerViewModel.savePlayerState()
            playerViewModel.releasePlayer()
        }
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(250.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CafiTechMediaAndroidView(player)
    }

    // Show error dialog if there is an error
    error?.let {
        when (it) {
            is PlayerError.NetworkError -> PlayerMediaErrorUI.PlayerMediaNetworkErrorUI {
                playerViewModel.clearError()
            }
            is PlayerError.FileNotFound -> PlayerMediaErrorUI.PlayerMediaFileNotFoundErrorUI {
                playerViewModel.clearError()
            }
            is PlayerError.DecoderError -> PlayerMediaErrorUI.PlayerMediaDecoderErrorUI {
                playerViewModel.clearError()
            }
            is PlayerError.UnknownError -> PlayerMediaErrorUI.PlayerMediaGeneralErrorUI(it.message ?: "Unknown error") {
                playerViewModel.clearError()
            }
        }
    }
}

