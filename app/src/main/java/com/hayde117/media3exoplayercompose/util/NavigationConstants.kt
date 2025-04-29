package com.hayde117.media3exoplayercompose.util

import android.os.Build
import android.os.Bundle
import android.os.Parcelable
import androidx.navigation.NavType
import kotlinx.serialization.KSerializer
import kotlinx.serialization.json.Json
import kotlin.reflect.KClass

/**
 * Object containing constants and utility classes related to navigation within the application.
 */
// todo move to core:util
object NavigationConstants {

    /**
     * A custom [NavType] implementation for handling [Parcelable] objects as navigation arguments,
     * leveraging Kotlin Serialization ([KSerializer]) for seamless serialization and deserialization.
     * This allows complex data objects to be passed between composable destinations in a type-safe manner.
     *
     * @param clazz The [KClass] of the [Parcelable] type being handled.
     * @param serializer The [KSerializer] for the [Parcelable] type, used for converting the object
     * to and from a string representation for navigation.
     */
    @Suppress("DEPRECATION", "OutdatedDocumentation")
    class CustomNavType<T : Parcelable>(
        private val clazz: KClass<T>,
        private val serializer: KSerializer<T>
    ) : NavType<T>(false) {
        override fun get(bundle: Bundle, key: String): T? {
            return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                bundle.getParcelable(key, clazz.java)
            } else {
                bundle.getParcelable(key)
            }
        }

        override fun parseValue(value: String): T {
            return Json.decodeFromString(serializer, value)
        }

        override fun put(bundle: Bundle, key: String, value: T) {
            bundle.putParcelable(key, value)
        }

        override fun serializeAsValue(value: T): String {
            return Json.encodeToString(serializer, value)
        }
    }
}
