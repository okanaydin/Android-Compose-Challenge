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
package com.example.androiddevchallenge.features.puppylistdetail

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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.LocalTextStyle
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.data.model.puppyList
import dev.chrisbanes.accompanist.coil.CoilImage
import dev.chrisbanes.accompanist.imageloading.ImageLoadState
import dev.chrisbanes.accompanist.imageloading.MaterialLoadingImage

@Composable
fun PuppyListDetailScreen(
    navController: NavController,
    puppyID: Int
) {

    val puppy = puppyList.find { puppy -> puppy.id == puppyID }

    Column {

        CoilImage(
            data = puppy!!.image,
        ) { imageState ->
            when (imageState) {
                is ImageLoadState.Success -> {
                    Card(
                        shape = RoundedCornerShape(bottomEnd = 20.dp, bottomStart = 20.dp)
                    ) {
                        MaterialLoadingImage(
                            result = imageState,
                            contentDescription = null,
                            fadeInEnabled = true,
                            fadeInDurationMs = 600,
                            modifier = Modifier.height(360.dp),
                            alignment = Alignment.Center,
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

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Card(
                modifier = Modifier.padding(start = 8.dp, top = 8.dp),
                shape = RoundedCornerShape(6.dp)
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .width(60.dp)
                        .height(50.dp)
                        .padding(top = 8.dp, bottom = 8.dp)
                ) {
                    Text(
                        text = stringResource(R.string.age),
                        style = LocalTextStyle.current.copy(
                            fontSize = 14.sp,
                            color = colorResource(id = R.color.grey_700),
                            fontFamily = FontFamily(Font(resId = R.font.nunito_light))
                        )
                    )
                    Text(
                        text = puppy.age.toString(),
                        style = LocalTextStyle.current.copy(
                            fontSize = 14.sp,
                            color = colorResource(id = R.color.grey_700),
                            fontFamily = FontFamily(Font(resId = R.font.nunito_bold))
                        )
                    )
                }
            }

            Card(
                modifier = Modifier.padding(start = 8.dp, top = 8.dp),
                shape = RoundedCornerShape(6.dp)
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .width(60.dp)
                        .height(50.dp)
                        .padding(top = 8.dp, bottom = 8.dp)
                ) {
                    Text(
                        text = stringResource(R.string.color),
                        style = LocalTextStyle.current.copy(
                            fontSize = 14.sp,
                            color = colorResource(id = R.color.grey_700),
                            fontFamily = FontFamily(Font(resId = R.font.nunito_light))
                        )
                    )
                    Text(
                        text = puppy.color,
                        style = LocalTextStyle.current.copy(
                            fontSize = 14.sp,
                            color = colorResource(id = R.color.grey_700),
                            fontFamily = FontFamily(Font(resId = R.font.nunito_bold))
                        )
                    )
                }
            }

            Card(
                modifier = Modifier.padding(start = 8.dp, top = 8.dp),
                shape = RoundedCornerShape(6.dp)
            ) {
                Column(
                    modifier = Modifier
                        .width(60.dp)
                        .height(50.dp)
                        .padding(top = 8.dp, bottom = 8.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = stringResource(R.string.sex),
                        style = LocalTextStyle.current.copy(
                            fontSize = 14.sp,
                            color = colorResource(id = R.color.grey_700),
                            fontFamily = FontFamily(Font(resId = R.font.nunito_light))
                        )
                    )

                    Text(
                        text = puppy.sex,
                        style = LocalTextStyle.current.copy(
                            fontSize = 14.sp,
                            color = colorResource(id = R.color.grey_700),
                            fontFamily = FontFamily(Font(resId = R.font.nunito_bold))
                        )
                    )
                }
            }

            Card(
                modifier = Modifier.padding(start = 8.dp, top = 8.dp),
                shape = RoundedCornerShape(6.dp)
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .width(60.dp)
                        .height(50.dp)
                        .padding(top = 8.dp, bottom = 8.dp)
                ) {
                    Text(
                        text = stringResource(R.string.weight),
                        style = LocalTextStyle.current.copy(
                            fontSize = 14.sp,
                            color = colorResource(id = R.color.grey_700),
                            fontFamily = FontFamily(Font(resId = R.font.nunito_light))
                        )
                    )
                    Text(
                        text = puppy.weight,
                        style = LocalTextStyle.current.copy(
                            fontSize = 14.sp,
                            color = colorResource(id = R.color.grey_700),
                            fontFamily = FontFamily(Font(resId = R.font.nunito_bold))
                        )
                    )
                }
            }
        }

        Text(
            text = puppy.name,
            modifier = Modifier.padding(start = 16.dp, top = 24.dp, end = 16.dp),
            style = LocalTextStyle.current.copy(
                fontSize = 24.sp,
                color = colorResource(id = R.color.dark_grey),
                fontFamily = FontFamily(Font(resId = R.font.nunito_semi_bold))
            )
        )

        Text(
            text = stringResource(R.string.lorem_text),
            modifier = Modifier.padding(start = 16.dp, top = 16.dp, end = 16.dp),
            style = LocalTextStyle.current.copy(
                fontSize = 14.sp,
                color = colorResource(id = R.color.grey_700),
                fontFamily = FontFamily(Font(resId = R.font.nunito_regular))
            )
        )

        Spacer(Modifier.requiredHeight(24.dp))

        Card(
            shape = RoundedCornerShape(20.dp),
            backgroundColor = colorResource(id = R.color.orange),
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp)
                .padding(start = 24.dp, end = 24.dp)
        ) {
            Text(
                text = stringResource(R.string.adopt_now),
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .padding(top = 16.dp),
                style = LocalTextStyle.current.copy(
                    fontSize = 18.sp,
                    color = colorResource(id = R.color.white_100),
                    fontFamily = FontFamily(Font(resId = R.font.nunito_bold)),
                    textAlign = TextAlign.Center
                )
            )
        }
    }
}
