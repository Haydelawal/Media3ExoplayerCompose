package com.hayde117.media3exoplayercompose.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.hayde117.media3exoplayercompose.data.MediaPlayerModel
import com.hayde117.media3exoplayercompose.ui.screens.ScreenA
import com.hayde117.media3exoplayercompose.ui.screens.ScreenB
import com.hayde117.media3exoplayercompose.ui.screens.ScreenC
import com.hayde117.media3exoplayercompose.util.Dest
import com.hayde117.media3exoplayercompose.util.NavigationConstants
import java.net.URLEncoder
import java.nio.charset.StandardCharsets
import kotlin.reflect.typeOf

@Composable
fun MainNavigation(modifier: Modifier = Modifier) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Dest.ScreenA) {

        composable<Dest.ScreenA> {
            ScreenA(
                modifier = modifier,
                onClick = {

                    val myMediaPlayerModel = MediaPlayerModel(
                        id = 7285,
                        name = "Ola Waller",
                        mediaUrl =
                            URLEncoder.encode(
                                "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4",
                                StandardCharsets.UTF_8.toString()
                            ))

                    navController.navigate(
                                Dest.ScreenB(mediaPlayerModel = myMediaPlayerModel)
                    )
                }
            )
        }

        composable<Dest.ScreenC> {
            ScreenC(modifier = modifier)
        }

        composable<Dest.ScreenB>(
            typeMap = mapOf(
                typeOf<MediaPlayerModel>() to NavigationConstants.CustomNavType<MediaPlayerModel>(
                    MediaPlayerModel::class,
                    MediaPlayerModel.serializer()
                )
            )
        ) { backStackEntry ->

            val myArgs = backStackEntry.toRoute<Dest.ScreenB>()

            ScreenB(
                modifier = modifier,
                args = myArgs.mediaPlayerModel,
                onNextButtonAction = {
                    navController.navigate(Dest.ScreenC)
                }
            )
        }


    }
}