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
package com.example.androiddevchallenge.ui

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.FabPosition
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Spa
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.ui.theme.MyTheme
import com.example.androiddevchallenge.ui.theme.taupe800
import dev.chrisbanes.accompanist.glide.GlideImage

@OptIn(ExperimentalStdlibApi::class)
@Composable
fun HomeScreen() {

  Scaffold(
    modifier = Modifier.fillMaxSize(),
    bottomBar = { HomeScreenNav() },
    floatingActionButton = {
      FloatingActionButton(
        onClick = { /*no op */ },
        backgroundColor = MaterialTheme.colors.primary,
      ) { Icon(Icons.Default.PlayArrow, contentDescription = "play") }
    },
    floatingActionButtonPosition = FabPosition.Center,
    isFloatingActionButtonDocked = true,

    ) { paddingValues ->

    Column(
      Modifier
        .verticalScroll(rememberScrollState())
        .padding(paddingValues)
    ) {

      MySootheTextField(
        value = "",
        onValueChange = { /* no op */ },
        modifier = Modifier.padding(top = 56.dp),
        placeholder = {
          Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(Icons.Default.Search, "Search", Modifier.size(18.dp))
            Spacer(modifier = Modifier.width(8.dp))
            Text("Search", style = MaterialTheme.typography.body1)
          }
        }
      )

      Text(
        text = "Favorite collections".uppercase(),
        style = MaterialTheme.typography.h2,
        color = taupe800,
        modifier = Modifier
          .paddingFromBaseline(top = 40.dp)
          .padding(horizontal = 16.dp)
          .wrapContentWidth(),
      )

      Spacer(modifier = Modifier.height(8.dp))

      FavoriteCollections()

      Alignments.forEach { (title, alignment) ->

        AlignmentSection(title, alignment)
      }
    }
  }
}

@OptIn(ExperimentalStdlibApi::class)
@Composable
fun ColumnScope.AlignmentSection(title: String, alignments: List<Pair<String, String>>) {

  Spacer(Modifier.height(32.dp))

  Text(
    text = title.uppercase(),
    style = MaterialTheme.typography.h2,
    color = taupe800,
    modifier = Modifier
      .padding(horizontal = 16.dp)
      .wrapContentWidth(),
  )

  Spacer(Modifier.height(8.dp))

  Row(
    Modifier
      .horizontalScroll(rememberScrollState())
      .padding(horizontal = 16.dp)
  ) {

    alignments.forEachIndexed { i, (name, image) ->

      Column {

        GlideImage(
          data = image,
          contentDescription = name,
          modifier = Modifier
            .size(88.dp)
            .clip(CircleShape),
          contentScale = ContentScale.Crop,
        )

        Text(
          text = name,
          style = MaterialTheme.typography.h3,
          modifier = Modifier
            .wrapContentWidth()
            .paddingFromBaseline(top = 24.dp),
        )
      }

      if (i != alignments.lastIndex) Spacer(Modifier.width(8.dp))
    }
  }
}

private val Alignments = mapOf(
  "Align your body" to listOf(
    "Inversions" to "https://images.pexels.com/photos/317157/pexels-photo-317157.jpeg?cs=srgb&dl=pexels-chevanon-photography-317157.jpg&fm=jpg",
    "Quick yoga" to "https://images.pexels.com/photos/1812964/pexels-photo-1812964.jpeg?cs=srgb&dl=pexels-agung-pandit-wiguna-1812964.jpg&fm=jpg",
    "Stretching" to "https://images.pexels.com/photos/4056723/pexels-photo-4056723.jpeg?cs=srgb&dl=pexels-cliff-booth-4056723.jpg&fm=jpg",
    "Tabata" to "https://images.pexels.com/photos/4662438/pexels-photo-4662438.jpeg?cs=srgb&dl=pexels-elly-fairytale-4662438.jpg&fm=jpg",
    "HIIT" to "https://images.pexels.com/photos/999309/pexels-photo-999309.jpeg?cs=srgb&dl=pexels-the-lazy-artist-gallery-999309.jpg&fm=jpg",
    "Pre-natal yoga" to "https://images.pexels.com/photos/396133/pexels-photo-396133.jpeg?cs=srgb&dl=pexels-freestocksorg-396133.jpg&fm=jpg",
  ),
  "Align your mind" to listOf(
    "Meditate" to "https://images.pexels.com/photos/3822622/pexels-photo-3822622.jpeg?cs=srgb&dl=pexels-elly-fairytale-3822622.jpg&fm=jpg",
    "With kids" to "https://images.pexels.com/photos/3094230/pexels-photo-3094230.jpeg?cs=srgb&dl=pexels-valeria-ushakova-3094230.jpg&fm=jpg",
    "Aromatherapy" to "https://images.pexels.com/photos/4498318/pexels-photo-4498318.jpeg?cs=srgb&dl=pexels-karolina-grabowska-4498318.jpg&fm=jpg",
    "On the go" to "https://images.pexels.com/photos/1241348/pexels-photo-1241348.jpeg?cs=srgb&dl=pexels-suraphat-nueaon-1241348.jpg&fm=jpg",
    "With pets" to "https://images.pexels.com/photos/4056535/pexels-photo-4056535.jpeg?cs=srgb&dl=pexels-cottonbro-4056535.jpg&fm=jpg",
    "High stress" to "https://images.pexels.com/photos/897817/pexels-photo-897817.jpeg?cs=srgb&dl=pexels-nathan-cowley-897817.jpg&fm=jpg",
  ),
)


@OptIn(ExperimentalStdlibApi::class)
@Composable
private fun HomeScreenNav() {

  val (selected, setSelected) = remember { mutableStateOf(0) }

  BottomNavigation(
    backgroundColor = MaterialTheme.colors.background,
    modifier = Modifier.height(56.dp),
  ) {

    NavigationItems.forEachIndexed { i, (label, icon) ->

      BottomNavigationItem(
        selected = i == selected,
        onClick = { setSelected(i) },
        icon = { Icon(icon, contentDescription = label, Modifier.size(18.dp)) },
        label = { Text(label.uppercase(), style = MaterialTheme.typography.caption) }
      )
    }
  }
}

val NavigationItems = listOf(
  "Home" to Icons.Default.Spa,
  "Profile" to Icons.Default.AccountCircle,
)


@Composable
private fun FavoriteCollections() {

  Row(
    Modifier
      .horizontalScroll(rememberScrollState())
      .padding(horizontal = 16.dp)
  ) {

    val windowed = Faves.windowed(2, 2)

    windowed.forEachIndexed { i, list ->
      FavoriteColumn(list)
      if (i != windowed.lastIndex) Spacer(Modifier.width(8.dp))
    }
  }
}

@Composable
private fun FavoriteColumn(list: List<Pair<String, String>>) {

  Column {
    list.forEachIndexed { i, (name, image) ->
      FavoriteItem(name, image)
      if (i != list.lastIndex) Spacer(Modifier.height(8.dp))
    }
  }
}

@Composable
private fun FavoriteItem(name: String, image: String) {
  Surface(
    Modifier.clip(
      MaterialTheme.shapes.small.copy(
        topEnd = CornerSize(0.dp),
        bottomEnd = CornerSize(0.dp)
      )
    )
  ) {
    Row(
      Modifier
        .size(width = 192.dp, height = 56.dp),
      verticalAlignment = Alignment.CenterVertically,
    ) {

      GlideImage(
        data = image,
        contentDescription = name,
        contentScale = ContentScale.Crop,
        modifier = Modifier.aspectRatio(1f),
      )

      Text(
        text = name,
        modifier = Modifier
          .weight(1f)
          .padding(horizontal = 16.dp),
        style = MaterialTheme.typography.h3,
      )
    }
  }
}

private val Faves = listOf(
  "Short mantras" to "https://images.pexels.com/photos/4515858/pexels-photo-4515858.jpeg?cs=srgb&dl=pexels-jacob-kelvinj-4515858.jpg&fm=jpg",
  "Nature meditations" to "https://images.pexels.com/photos/3571551/pexels-photo-3571551.jpeg?cs=srgb&dl=pexels-nothing-ahead-3571551.jpg&fm=jpg",
  "Stress & anxiety" to "https://images.pexels.com/photos/1557238/pexels-photo-1557238.jpeg?cs=srgb&dl=pexels-jim-1557238.jpg&fm=jpg",
  "Self-massage" to "https://images.pexels.com/photos/1029604/pexels-photo-1029604.jpeg?cs=srgb&dl=pexels-scott-webb-1029604.jpg&fm=jpg",
  "Overwhelmed" to "https://images.pexels.com/photos/3560044/pexels-photo-3560044.jpeg?cs=srgb&dl=pexels-ruvim-3560044.jpg&fm=jpg",
  "Nightly wind down" to "https://images.pexels.com/photos/924824/pexels-photo-924824.jpeg?cs=srgb&dl=pexels-jakub-novacek-924824.jpg&fm=jpg"
)


@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
private fun LightPreview() {
  MyTheme { HomeScreen() }
}

@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
private fun DarkPreview() {
  MyTheme(darkTheme = true) { HomeScreen() }
}
