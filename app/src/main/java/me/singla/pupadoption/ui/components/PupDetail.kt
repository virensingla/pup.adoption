package me.singla.pupadoption.ui.components

import androidx.compose.animation.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import me.singla.pupadoption.R
import me.singla.pupadoption.data.About
import me.singla.pupadoption.data.Pup
import me.singla.pupadoption.data.pupsData

@ExperimentalAnimationApi
@Composable
fun PupDetail(
    pup: Pup,
    upPress: () -> Unit
) {
    Box(Modifier.fillMaxSize()) {
        val scroll = rememberScrollState(100)
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .height(350.dp),
            painter = painterResource(id = pup.image),
            contentDescription = stringResource(id = R.string.pup_image),
            contentScale = ContentScale.Crop
        )

        AnimatedVisibility(visible = scroll.value < 150, enter = fadeIn(), exit = fadeOut(), modifier = Modifier.zIndex(2F)) {
            IconButton(
                onClick = { upPress() },
                modifier = Modifier
                    .padding(16.dp)
                    .clip(RoundedCornerShape(percent = 50))
                    .background(Color.Black.copy(alpha = 0.7F))
            ) {
                Icon(
                    imageVector = Icons.Rounded.ArrowBack,
                    contentDescription = stringResource(id = R.string.go_back),
                    tint = Color.White
                )
            }
        }

        Card(
            Modifier
                .verticalScroll(scroll)
                .padding(top = 300.dp)
                .clip(RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp))
                .background(color = Color.White),
            elevation = 8.dp
        ) {

            Column(
                Modifier
                    .fillMaxWidth()
                    .padding(all = 24.dp)
                    .defaultMinSize(minHeight = 50.dp)
            ) {
                Row(Modifier.fillMaxWidth()) {
                    Image(
                        modifier = Modifier
                            .height(24.dp)
                            .width(24.dp),
                        painter = painterResource(id = R.drawable.location_pin),
                        contentDescription = stringResource(id = R.string.pup_address)
                    )
                    Text(
                        modifier = Modifier.padding(start = 16.dp),
                        style = MaterialTheme.typography.subtitle2.copy(
                            MaterialTheme.colors.onBackground.copy(
                                alpha = .7F
                            )
                        ),
                        text = pup.location
                    )
                }
                Row(modifier = Modifier.padding(top = 24.dp)) {
                    Column(Modifier.weight(1F)) {
                        Text(
                            style = MaterialTheme.typography.h5,
                            text = pup.name
                        )
                        Text(
                            modifier = Modifier.padding(top = 2.dp),
                            style = MaterialTheme.typography.body1,
                            text = pup.breed
                        )
                    }
                    Image(
                        modifier = Modifier
                            .align(Alignment.CenterVertically)
                            .height(30.dp)
                            .width(30.dp),
                        painter = painterResource(id = if (pup.isMale) R.drawable.man else R.drawable.woman),
                        contentDescription = stringResource(id = R.string.pup_gender)
                    )
                }

                Text(
                    text = About.value,
                    style = MaterialTheme.typography.body1,
                    modifier = Modifier.padding(top = 16.dp)
                )

                Text(
                    text = stringResource(id = R.string.gallery),
                    style = MaterialTheme.typography.subtitle2.copy(
                        color = MaterialTheme.colors.onBackground.copy(
                            alpha = 0.7F
                        )
                    ),
                    modifier = Modifier.padding(top = 16.dp)
                )

                Row(Modifier.padding(top = 8.dp)) {
                    Card(Modifier.size(64.dp), elevation = 2.dp) {
                        Image(
                            painter = painterResource(id = R.drawable.pup_gallery_1),
                            contentDescription = stringResource(id = R.string.pup_image),
                            modifier = Modifier.fillMaxSize()
                        )
                    }
                    Spacer(modifier = Modifier.width(16.dp))
                    Card(Modifier.size(64.dp), elevation = 2.dp) {
                        Image(
                            painter = painterResource(id = R.drawable.pup_gallery_2),
                            contentDescription = "",
                            modifier = Modifier.fillMaxSize()
                        )
                    }
                }

                Spacer(modifier = Modifier.height(70.dp))
            }
        }

        Button(
            onClick = { /*TODO*/ }, modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 32.dp, vertical = 16.dp)
                .height(50.dp)
                .align(Alignment.BottomCenter),
            shape = RoundedCornerShape(size = 24.dp)
        ) {
            Text(text = "ADOPT ME")
        }


    }
}

@ExperimentalAnimationApi
@Preview
@Composable
fun PupDetailPreview() {
    PupDetail(pupsData[2], upPress = {})
}