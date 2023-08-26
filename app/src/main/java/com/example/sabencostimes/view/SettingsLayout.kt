package com.example.sabencostimes.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.example.sabencostimes.R

@Composable
fun SettingsLayout(){
    Column {
        Row {
         Text(text = "Version:")
         Text(text = stringResource(id = R.string.app_version))
        }
    }
}