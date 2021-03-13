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

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp

@Composable
internal fun MySootheTextField(
  value: String,
  onValueChange: (String) -> Unit,
  modifier: Modifier = Modifier,
  placeholderText: String? = null,
  placeholder: @Composable () -> Unit = {
    if (placeholderText != null) Text(placeholderText, style = MaterialTheme.typography.body1)
  },
  visualTransformation: VisualTransformation = VisualTransformation.None,
) {
  TextField(
    value = value,
    onValueChange = onValueChange,
    modifier = modifier
      .padding(horizontal = 16.dp)
      .fillMaxWidth()
      .height(56.dp),
    textStyle = MaterialTheme.typography.body1,
    placeholder = placeholder,
    visualTransformation = visualTransformation,
    colors = TextFieldDefaults.textFieldColors(backgroundColor = MaterialTheme.colors.surface)
  )
}
