package me.singla.pupadoption

import android.os.Parcelable
import androidx.compose.runtime.Immutable
import kotlinx.parcelize.Parcelize
import me.singla.pupadoption.data.Pup
import me.singla.pupadoption.utils.Navigator

/**
 * Models the screens in the app and any arguments they require.
 */
sealed class Destination : Parcelable {
    @Parcelize
    object Home : Destination()

    @Immutable
    @Parcelize
    data class PupDetail(val pup: Pup) : Destination()
}

/**
 * Models the navigation actions in the app.
 */
class Actions(navigator: Navigator<Destination>) {
    val selectPup: (Pup) -> Unit = { pup: Pup ->
        navigator.navigate(Destination.PupDetail(pup))
    }
    val upPress: () -> Unit = {
        navigator.back()
    }
}