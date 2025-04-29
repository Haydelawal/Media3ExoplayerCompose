# Media3 ExoPlayer Compose Demo

This Android application demonstrates the integration of Media3's ExoPlayer with Jetpack Compose for media playback. It showcases a simple navigation structure and handles common media playback errors.

## Features

* **ExoPlayer Integration:** Utilizes Media3's ExoPlayer for robust media playback capabilities.
* **Jetpack Compose UI:** Builds the user interface using modern Jetpack Compose.
* **Navigation:** Implements navigation between different screens using `androidx.navigation`.
* **Error Handling:** Gracefully handles and displays common media playback errors (e.g., network errors, file not found, decoder errors).
* **Parcelable Data Class:** Uses a `Parcelable` data class (`MediaPlayerModel`) to pass media information between screens.
* **Custom Navigation Type:** Includes a custom `NavType` to handle `Parcelable` objects with Kotlin Serialization for type-safe navigation.

## Technologies Used

* Kotlin
* Jetpack Compose
* Media3 ExoPlayer
* AndroidX Navigation
* Kotlin Serialization

## Architecture

The application follows a simple structure with the following key components:

* **`MainActivity`:** The main activity that sets up the Compose UI and navigation.
* **`MainNavigation`:** Handles navigation between screens using `NavHost`.
* **Screens (A, B, C):**
    * `ScreenA`:  The starting screen that initiates navigation to `ScreenB` with media details.
    * `ScreenB`:  Displays the media player using `CafiTechPlayerView` and `CafiTechMediaAndroidView`.
    * `ScreenC`:  A simple destination screen (can be extended for additional functionality).
* **`CafiTechPlayerView`:** A Composable that manages the ExoPlayer lifecycle, initializes the player, and displays it using `CafiTechMediaAndroidView`. It also handles error display.
* **`CafiTechMediaAndroidView`:** A Composable that wraps the `PlayerView` from ExoPlayer for display in Compose.
* **`PlayerViewModel`:** A `ViewModel` that manages the ExoPlayer instance, handles media playback, and exposes player state and errors.
* **`MediaPlayerModel`:** A `Parcelable` data class to hold media information (id, name, mediaUrl).
* **`PlayerError`:** A sealed class to represent different types of player errors.
* **`PlayerMediaErrorUI`:** A utility object containing Composable functions to display user-friendly error dialogs.
* **`NavigationConstants`:** Contains a custom `NavType` (`CustomNavType`) for handling `Parcelable` objects in navigation.
* **`Dest`:** A sealed class defining the navigation destinations.

## Getting Started

1.  **Clone the repository:**
    ```bash
    git clone <repository_url>
    ```
2.  **Open the project** in Android Studio.
3.  **Build and run** the application on an emulator or physical device.

## Navigation

The application demonstrates basic navigation:

* Screen A navigates to Screen B, passing a `MediaPlayerModel` containing the media URL.
* Screen B displays the media player.
* Screen B has a button to navigate to Screen C.

## Error Handling

The application includes error handling for common media playback issues:

* **Network Error:** Displayed when there's a problem with the network connection.
* **File Not Found Error:** Displayed when the media file cannot be found.
* **Decoder Error:** Displayed when there's an issue with decoding the media.
* **General Error:** Displayed for any other unexpected error, with a message provided.

Error dialogs are shown using the Composables in `PlayerMediaErrorUI`.

## Custom Navigation Type

The `CustomNavType` in `NavigationConstants` enables type-safe passing of `Parcelable` objects (specifically `MediaPlayerModel`) between navigation destinations.  This leverages Kotlin Serialization to convert the object to a string for navigation and back to an object when received.

## Future Enhancements

* Add more advanced player controls (play/pause, seek, volume, etc.).
* Implement a more complex UI with different layouts and styles.
* Support for different media types (audio, etc.).
* Add unit and UI tests.
* Improve error handling and logging.
* Implement state persistence.

## Contributing

Contributions are welcome! Please feel free to submit pull requests or open issues.
