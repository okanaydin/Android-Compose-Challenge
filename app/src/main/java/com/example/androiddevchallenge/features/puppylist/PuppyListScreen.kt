/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge.features.puppylist

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.LocalTextStyle
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.navigate
import androidx.navigation.compose.rememberNavController
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.data.model.Puppy
import com.example.androiddevchallenge.data.model.puppyList
import com.example.androiddevchallenge.ui.theme.MyTheme
import com.example.androiddevchallenge.util.Routes
import dev.chrisbanes.accompanist.coil.CoilImage
import dev.chrisbanes.accompanist.imageloading.ImageLoadState
import dev.chrisbanes.accompanist.imageloading.MaterialLoadingImage

@Composable
fun PuppyListScreen(
    navController: NavController
) {

    MaterialTheme {
        Column(
            horizontalAlignment = Alignment.Start,
            modifier = Modifier
                .fillMaxWidth()
                .background(colorResource(id = R.color.white_100))
                .padding(start = 24.dp, top = 16.dp, end = 24.dp)
        ) {
            Row {
                Text(
                    text = stringResource(id = R.string.adopt_puppy),
                    color = colorResource(id = R.color.dark_grey),
                    style = LocalTextStyle.current.copy(
                        fontSize = 32.sp,
                        fontFamily = FontFamily(Font(resId = R.font.nunito_bold))
                    )
                )
                Image(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(40.dp),
                    contentDescription = null,
                    alignment = Alignment.CenterEnd,
                    painter = painterResource(R.drawable.art_puppy),
                )
            }

            Text(
                text = stringResource(R.string.your_favourite_soulmate_pet),
                color = colorResource(id = R.color.grey_200),
                style = LocalTextStyle.current.copy(
                    fontSize = 16.sp,
                    fontFamily = FontFamily(Font(resId = R.font.nunito_semi_bold))
                )
            )

            Card(
                backgroundColor = colorResource(id = R.color.white),
                elevation = 1.dp, shape = RoundedCornerShape(16.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 24.dp)
            ) {
                Row {
                    Text(
                        text = stringResource(R.string.search_your_soulmate_pet),
                        color = colorResource(id = R.color.grey_200),
                        modifier = Modifier.padding(16.dp),
                        style = LocalTextStyle.current.copy(
                            fontSize = 12.sp,
                            fontFamily = FontFamily(Font(resId = R.font.nunito_semi_bold)),
                            textAlign = TextAlign.Center
                        )
                    )
                    Image(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp),
                        painter = painterResource(id = R.drawable.ic_search),
                        contentDescription = null,
                        alignment = Alignment.CenterEnd
                    )
                }
            }

            Spacer(modifier = Modifier.requiredHeight(16.dp))

            Surface(color = colorResource(id = R.color.white_100)) {
                LazyRow {
                    items(puppyList) { puppy ->
                        PuppyListFilter(puppy)
                    }
                }
            }

            Spacer(modifier = Modifier.requiredHeight(8.dp))

            PuppyList(
                onItemClicked = { currentPuppy ->
                    navController.navigate(Routes.createPuppyListDetailDirection(puppyList[currentPuppy]))
                }
            )
        }
    }
}

@Composable
fun PuppyList(onItemClicked: (index: Int) -> Unit) {
    Surface(color = colorResource(id = R.color.white_100)) {
        LazyColumn(
            modifier = Modifier
                .padding(bottom = 16.dp)
                .clickable { onItemClicked }
        ) {
            itemsIndexed(puppyList) { index, puppy ->
                PuppyListItem(puppy, index, onItemClicked)
            }
        }
    }
}

@Composable
fun PuppyListItem(puppy: Puppy, index: Int, onItemClicked: (index: Int) -> Unit) {
    Card(
        backgroundColor = colorResource(id = R.color.white),
        shape = RoundedCornerShape(16.dp),
        modifier = Modifier.padding(
            top = 16.dp, start = 2.dp, end = 2.dp
        )
    ) {

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .clickable(onClick = { onItemClicked(index) })
        ) {

            CoilImage(data = puppy.image) { imageState ->
                when (imageState) {
                    is ImageLoadState.Success -> {
                        Card(
                            modifier = Modifier.padding(8.dp),
                            shape = RoundedCornerShape(46.dp)
                        ) {
                            MaterialLoadingImage(
                                result = imageState,
                                contentDescription = null,
                                fadeInEnabled = true,
                                fadeInDurationMs = 600,
                                modifier = Modifier
                                    .height(96.dp)
                                    .width(96.dp),
                                contentScale = ContentScale.FillBounds,
                                skipFadeWhenLoadedFromMemory = true
                            )
                        }
                    }
                    is ImageLoadState.Error -> Text(text = "Error")
                    is ImageLoadState.Loading -> Text(text = "Loading")
                    is ImageLoadState.Empty -> Text(text = "Empty")
                }
            }

            Column(
                horizontalAlignment = Alignment.Start,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp, bottom = 8.dp)
            ) {
                Text(
                    text = puppy.name,
                    modifier = Modifier.padding(start = 6.dp),
                    style = LocalTextStyle.current.copy(
                        color = colorResource(id = R.color.grey_700),
                        fontSize = 20.sp,
                        fontFamily = FontFamily(Font(resId = R.font.nunito_semi_bold))
                    )
                )

                Row(
                    modifier = Modifier
                        .height(24.dp)
                        .padding(top = 8.dp)
                ) {

                    Image(
                        painter = painterResource(R.drawable.art_puppy),
                        contentDescription = null,
                        modifier = Modifier
                            .width(20.dp)
                            .height(20.dp)
                            .padding(start = 6.dp)
                    )

                    Text(
                        text = puppy.breed,
                        modifier = Modifier
                            .padding(start = 4.dp)
                            .height(24.dp),
                        style = LocalTextStyle.current.copy(
                            fontSize = 12.sp,
                            color = colorResource(id = R.color.grey_200),
                            fontFamily = FontFamily(Font(resId = R.font.nunito_semi_bold)),
                            textAlign = TextAlign.Center
                        )
                    )
                }

                Spacer(Modifier.requiredHeight(12.dp))

                Row {
                    Card(
                        shape = RoundedCornerShape(8.dp),
                        backgroundColor = colorResource(id = R.color.red),
                        modifier = Modifier
                            .padding(6.dp)
                            .width(50.dp)
                            .height(24.dp)
                    ) {
                        Text(
                            text = puppy.color,
                            modifier = Modifier
                                .fillMaxHeight()
                                .fillMaxWidth()
                                .padding(4.dp),
                            style = LocalTextStyle.current.copy(
                                fontSize = 12.sp,
                                color = colorResource(id = R.color.white),
                                fontFamily = FontFamily(Font(resId = R.font.nunito_semi_bold)),
                                textAlign = TextAlign.Center
                            )
                        )
                    }

                    Card(
                        shape = RoundedCornerShape(8.dp),
                        backgroundColor = colorResource(id = R.color.cyan),
                        modifier = Modifier
                            .padding(6.dp)
                            .width(50.dp)
                            .height(24.dp)
                    ) {
                        Text(
                            text = puppy.sex,
                            modifier = Modifier
                                .fillMaxHeight()
                                .fillMaxWidth()
                                .padding(4.dp),
                            style = LocalTextStyle.current.copy(
                                fontSize = 12.sp,
                                color = colorResource(id = R.color.white),
                                fontFamily = FontFamily(Font(resId = R.font.nunito_semi_bold)),
                                textAlign = TextAlign.Center
                            )
                        )
                    }

                    Card(
                        shape = RoundedCornerShape(8.dp),
                        backgroundColor = colorResource(id = R.color.yellow),
                        modifier = Modifier
                            .padding(6.dp)
                            .width(50.dp)
                            .height(24.dp)
                    ) {
                        Text(
                            text = "${puppy.age} year",
                            modifier = Modifier
                                .fillMaxHeight()
                                .fillMaxWidth()
                                .padding(4.dp),
                            style = LocalTextStyle.current.copy(
                                fontSize = 12.sp,
                                color = colorResource(id = R.color.white),
                                fontFamily = FontFamily(Font(resId = R.font.nunito_semi_bold)),
                                textAlign = TextAlign.Center
                            )
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun PuppyListFilter(puppy: Puppy) {
    Card(
        backgroundColor = colorResource(id = R.color.white),
        shape = RoundedCornerShape(16.dp),
        modifier = Modifier
            .padding(start = 4.dp, top = 2.dp, end = 4.dp, bottom = 2.dp)
            .width(75.dp)
            .height(30.dp),
    ) {
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {

            CoilImage(data = puppy.image) { imageState ->
                when (imageState) {
                    is ImageLoadState.Success -> {
                        Card(
                            shape = RoundedCornerShape(10.dp)
                        ) {
                            MaterialLoadingImage(
                                result = imageState,
                                contentDescription = null,
                                fadeInEnabled = true,
                                fadeInDurationMs = 600,
                                modifier = Modifier
                                    .width(20.dp)
                                    .height(20.dp),
                                contentScale = ContentScale.FillBounds,
                                skipFadeWhenLoadedFromMemory = true
                            )
                        }
                    }
                    is ImageLoadState.Error -> Text(text = "Error")
                    is ImageLoadState.Loading -> Text(text = "Loading")
                    is ImageLoadState.Empty -> Text(text = "Empty")
                }
            }

            Text(
                text = puppy.breed,
                modifier = Modifier.padding(start = 4.dp),
                style = LocalTextStyle.current.copy(
                    fontSize = 12.sp,
                    color = colorResource(id = R.color.grey_200),
                    fontFamily = FontFamily(Font(resId = R.font.nunito_semi_bold)),
                    textAlign = TextAlign.Center,
                )
            )
        }
    }
}

@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun LightPreview() {
    MyTheme {
        PuppyListScreen(navController = rememberNavController())
    }
}

@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun DarkPreview() {
    MyTheme(darkTheme = true) {
        PuppyListScreen(navController = rememberNavController())
    }
}
