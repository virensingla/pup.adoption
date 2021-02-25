package me.singla.pupadoption

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import me.singla.pupadoption.ui.App
import me.singla.pupadoption.ui.components.Feed
import me.singla.pupadoption.ui.theme.PupAdoptionTheme

class MainActivity : AppCompatActivity() {
    @ExperimentalAnimationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            App(backDispatcher = onBackPressedDispatcher)
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    PupAdoptionTheme {
        Feed {}
    }
}
