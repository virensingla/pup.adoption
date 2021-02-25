package me.singla.pupadoption.ui

import androidx.activity.OnBackPressedDispatcher
import androidx.compose.animation.Crossfade
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import me.singla.pupadoption.Actions
import me.singla.pupadoption.Destination
import me.singla.pupadoption.ui.components.Feed
import me.singla.pupadoption.ui.components.PupDetail
import me.singla.pupadoption.ui.theme.PupAdoptionTheme
import me.singla.pupadoption.utils.Navigator

@ExperimentalAnimationApi
@Composable
fun App(backDispatcher: OnBackPressedDispatcher) {
    val navigator: Navigator<Destination> = rememberSaveable(
        saver = Navigator.saver(backDispatcher)
    ) {
        Navigator(Destination.Home, backDispatcher)
    }

    val actions = remember(navigator) { Actions(navigator) }
    PupAdoptionTheme() {
        Surface(color = MaterialTheme.colors.background){
            Crossfade(navigator.current) { destination ->
                when (destination) {
                    Destination.Home -> Feed(actions.selectPup)
                    is Destination.PupDetail -> PupDetail (
                        pup = destination.pup,
                        upPress = actions.upPress
                    )
                }
            }
        }
    }
}