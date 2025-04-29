package com.hayde117.media3exoplayercompose.util

sealed class PlayerError {
    object NetworkError : PlayerError()
    object FileNotFound : PlayerError()
    object DecoderError : PlayerError()
    data class UnknownError(val message: String?) : PlayerError()
}