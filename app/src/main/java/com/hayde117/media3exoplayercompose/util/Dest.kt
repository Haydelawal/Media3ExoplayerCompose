package com.hayde117.media3exoplayercompose.util

import com.hayde117.media3exoplayercompose.data.MediaPlayerModel
import kotlinx.serialization.Serializable

sealed class Dest {

    @Serializable
    data object ScreenA : Dest()

    @Serializable
    data class ScreenB (val mediaPlayerModel: MediaPlayerModel) : Dest()

    @Serializable
    data object ScreenC : Dest()
}