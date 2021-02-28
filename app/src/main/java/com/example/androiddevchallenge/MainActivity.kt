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
package com.example.androiddevchallenge

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import androidx.navigation.compose.rememberNavController
import com.example.androiddevchallenge.features.onboarding.OnboardingScreen
import com.example.androiddevchallenge.features.puppylist.PuppyListScreen
import com.example.androiddevchallenge.features.puppylistdetail.PuppyListDetailScreen
import com.example.androiddevchallenge.ui.theme.MyTheme
import com.example.androiddevchallenge.util.Routes
import com.example.androiddevchallenge.util.Routes.PUPPY_LIST_DETAIL_ARGUMENT
import com.example.androiddevchallenge.util.Routes.PUPPY_LIST_DETAIL_SCREEN

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyTheme {
                MyApp()
            }
        }
    }
}

// Start building your app here!
@Composable
fun MyApp() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Routes.ONBOARDING_SCREEN) {

        composable(Routes.ONBOARDING_SCREEN) {
            OnboardingScreen(navController = navController)
        }

        composable(Routes.PUPPY_LIST_SCREEN) {
            PuppyListScreen(navController = navController)
        }

        composable(
            route = PUPPY_LIST_DETAIL_SCREEN,
            arguments = listOf(navArgument(PUPPY_LIST_DETAIL_ARGUMENT) { type = NavType.IntType })
        ) {
            it.arguments?.getInt(PUPPY_LIST_DETAIL_ARGUMENT)?.let { puppyID ->
                PuppyListDetailScreen(
                    navController,
                    puppyID
                )
            }
        }
    }
}

@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun LightPreview() {
    MyTheme {
        MyApp()
    }
}

@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun DarkPreview() {
    MyTheme(darkTheme = true) {
        MyApp()
    }
}
