package com.hayde117.media3exoplayercompose.util

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

object PlayerMediaErrorUI {

    @Composable
    fun PlayerMediaNetworkErrorUI(onDismiss: () -> Unit) {
        AlertDialog(
            onDismissRequest = onDismiss,
            title = { Text("Network Error") },
            text = { Text("Please check your internet connection and try again.") },
            confirmButton = {
                Button(onClick = onDismiss) {
                    Text("OK")
                }
            }
        )
    }

    @Composable
    fun PlayerMediaFileNotFoundErrorUI(onDismiss: () -> Unit) {
        AlertDialog(
            onDismissRequest = onDismiss,
            title = { Text("File Not Found Error") },
            text = { Text("Please check your internet connection and try again.") },
            confirmButton = {
                Button(onClick = onDismiss) {
                    Text("OK")
                }
            }
        )
    }

    @Composable
    fun PlayerMediaDecoderErrorUI(onDismiss: () -> Unit) {
        AlertDialog(
            onDismissRequest = onDismiss,
            title = { Text("Decoder Error") },
            text = { Text("Please check your internet connection and try again.") },
            confirmButton = {
                Button(onClick = onDismiss) {
                    Text("OK")
                }
            }
        )
    }

    @Composable
    fun PlayerMediaGeneralErrorUI(message: String, onDismiss: () -> Unit) {
        AlertDialog(
            onDismissRequest = onDismiss,
            title = { Text("Media Error") },
            text = { Text(message) },
            confirmButton = {
                Button(onClick = onDismiss) {
                    Text("OK")
                }
            }
        )
    }

}



