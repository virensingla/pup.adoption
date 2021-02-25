package me.singla.pupadoption.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
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
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import me.singla.pupadoption.R
import me.singla.pupadoption.data.Pup

@Composable
fun Pup(pup: Pup, onPupSelected: (Pup) -> Unit) {
    Column(
        Modifier
            .fillMaxWidth()
            .padding(all = 8.dp)
    ) {
        Card(
            Modifier
                .fillMaxWidth()
                .aspectRatio(.8f)
                .clip(RoundedCornerShape(8.dp))
                .shadow(2.dp)
                .clickable {
                    onPupSelected.invoke(pup)
                }
        ) {
            Box(
                Modifier
                    .fillMaxSize()
            ) {
                Image(
                    painter = painterResource(id = pup.image),
                    contentDescription = stringResource(id = R.string.pup),
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Crop
                )
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .align(Alignment.BottomStart)
                        .background(
                            Brush.verticalGradient(
                                colors = listOf(
                                    Color.Black.copy(alpha = 0F),
                                    Color.Black.copy(alpha = .5F)
                                )
                            )
                        )
                ) {
                    Column(
                        Modifier
                            .padding(6.dp)
                            .padding(top = 12.dp)
                    ) {
                        Text(
                            text = pup.name,
                            maxLines = 2,
                            overflow = TextOverflow.Ellipsis,
                            style = MaterialTheme.typography.h6.copy(color = Color.White)
                        )
                        Text(
                            text = pup.breed,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis,
                            style = MaterialTheme.typography.subtitle1.copy(color = Color.White)
                        )
                    }

                }
            }
        }

    }
}