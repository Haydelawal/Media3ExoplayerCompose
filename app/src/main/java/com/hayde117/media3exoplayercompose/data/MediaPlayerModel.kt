package com.hayde117.media3exoplayercompose.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.Serializable

@Parcelize
@Serializable
data class MediaPlayerModel(
    val id: Int? = 0,
    val name: String? = "",
    val mediaUrl: String? = ""
) : Parcelable