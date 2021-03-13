package com.example.androiddevchallenge.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.ui.theme.MyTheme

@OptIn(ExperimentalStdlibApi::class)
@Composable
fun WelcomeScreen(onClickLogin: () -> Unit = {}) {
  val isLight = MaterialTheme.colors.isLight

  val bg = painterResource(id = if (isLight) R.drawable.light_welcome else R.drawable.dark_welcome)
  val logo = painterResource(id = if (isLight) R.drawable.light_logo else R.drawable.dark_logo)

  Surface(Modifier.fillMaxSize(), color = MaterialTheme.colors.background) {

    Image(bg, "welcome background")

    Column(
      Modifier.fillMaxSize(),
      verticalArrangement = Arrangement.Center,
      horizontalAlignment = Alignment.CenterHorizontally
    ) {

      Image(logo, contentDescription = "welcome logo")

      Spacer(Modifier.height(32.dp))

      Button(
        onClick = { /* no op */ },
        modifier = Modifier
          .height(72.dp)
          .fillMaxWidth()
          .padding(horizontal = 16.dp),
        shape = MaterialTheme.shapes.medium,
      ) {
        Text("Sign up".uppercase())
      }

      Spacer(Modifier.height(8.dp))

      Button(
        onClick = onClickLogin,
        modifier = Modifier
          .height(72.dp)
          .fillMaxWidth()
          .padding(horizontal = 16.dp),
        colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.secondary),
        shape = MaterialTheme.shapes.medium,
      ) {
        Text("Log in".uppercase())
      }
    }
  }
}


@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
private fun LightPreview() {
  MyTheme { WelcomeScreen() }
}

@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
private fun DarkPreview() {
  MyTheme(darkTheme = true) { WelcomeScreen() }
}
