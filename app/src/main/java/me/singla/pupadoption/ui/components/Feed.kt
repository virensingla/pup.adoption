package me.singla.pupadoption.ui.components

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.LocationOn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import me.singla.pupadoption.R
import me.singla.pupadoption.data.Pup
import me.singla.pupadoption.data.pupsData

@Composable
fun Feed(onPupSelected: (Pup) -> Unit) {
    Box(modifier = Modifier.fillMaxSize()) {
        val scroll = rememberScrollState(0)
        Column(Modifier.verticalScroll(scroll)) {
            Spacer(modifier = Modifier.height(52.dp))
            VerticalGrid(
                Modifier
                    .padding(all = 8.dp)
            ) {
                pupsData.map { pup ->
                    Pup(pup = pup, onPupSelected = onPupSelected)
                }
            }
        }

        TopAppBar(backgroundColor = MaterialTheme.colors.primary.copy(alpha = 0.9F)) {
            Text(
                text = "Port Angeles, WA",
                style = MaterialTheme.typography.subtitle1.copy(color = MaterialTheme.colors.onPrimary),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .weight(1f)
                    .align(Alignment.CenterVertically)
            )
            IconButton(
                onClick = { /*TODO*/ },

                modifier = Modifier.align(Alignment.CenterVertically)
            ) {
                Icon(
                    imageVector = Icons.Outlined.LocationOn,
                    tint = MaterialTheme.colors.onPrimary,
                    contentDescription = stringResource(id = R.string.your_location)
                )

            }
        }
    }
}