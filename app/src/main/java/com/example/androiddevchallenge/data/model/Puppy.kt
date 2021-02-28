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
package com.example.androiddevchallenge.data.model

data class Puppy(
    val id: Int,
    val name: String,
    val breed: String,
    val age: Int,
    val image: String,
    val color: String,
    val sex: String,
    val weight: String,
)

val images = listOf(
    "https://images.unsplash.com/photo-1517423440428-a5a00ad493e8?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=687&q=80",
    "https://images.unsplash.com/photo-1583512603805-3cc6b41f3edb?ixlib=rb-1.2.1&ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&auto=format&fit=crop&w=800&q=80",
    "https://images.unsplash.com/photo-1583511655857-d19b40a7a54e?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=1049&q=80",
    "https://images.unsplash.com/photo-1517423568366-8b83523034fd?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=675&q=80",
    "https://images.unsplash.com/photo-1517849845537-4d257902454a?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=675&q=80",
    "https://images.unsplash.com/photo-1585559700398-1385b3a8aeb6?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=634&q=80",
    "https://images.unsplash.com/photo-1558788353-f76d92427f16?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=678&q=80",
    "https://images.unsplash.com/photo-1537151672256-6caf2e9f8c95?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=633&q=80",
    "https://images.unsplash.com/photo-1588269845464-8993565cac3a?ixlib=rb-1.2.1&ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&auto=format&fit=crop&w=634&q=80",
    "https://images.unsplash.com/photo-1530041539828-114de669390e?ixlib=rb-1.2.1&ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&auto=format&fit=crop&w=634&q=80"
)

val puppyList = listOf(
    Puppy(1001, "Carmen", "Barbet", 1, images[0], "White", "Male", "2KG"),
    Puppy(1002, "Lola", "Terrier", 2, images[1], "Black", "Male", "2KG"),
    Puppy(1003, "Coco", "Boxer", 1, images[2], "White", "Male", "2KG"),
    Puppy(1004, "Wand", "Pug", 2, images[3], "White", "Male", "2KG"),
    Puppy(1005, "Nugget", "Drev", 2, images[4], "Black", "Female", "2KG"),
    Puppy(1006, "Sugar", "Chug", 1, images[5], "White", "Male", "2KG"),
    Puppy(1007, "Charlie", "Dorgi", 1, images[6], "White", "Male", "2KG"),
    Puppy(1008, "Max", "Golden", 1, images[7], "Black", "Male", "2KG"),
    Puppy(1009, "Buddy", "Morkie", 2, images[8], "White", "Male", "2KG"),
    Puppy(1010, "Teddy", "Pug", 1, images[9], "White", "Male", "2KG")
)
