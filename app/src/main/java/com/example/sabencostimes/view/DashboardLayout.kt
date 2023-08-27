package com.example.sabencostimes.view

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import com.example.sabencostimes.viewmodel.DashboardViewModel

@Composable
fun DashboardLayout(){
    Text(text = "This is Dashboard")
    val viewModel = DashboardViewModel()
}