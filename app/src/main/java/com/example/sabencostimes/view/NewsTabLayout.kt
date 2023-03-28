package com.example.sabencostimes.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.sabencostimes.viewmodel.NewsDashModelFactory
import com.example.sabencostimes.viewmodel.NewsDashViewModel

@Composable
fun NewsTabLayout(navHostController: NavHostController,viewmodel: NewsDashViewModel =  viewModel(factory = NewsDashModelFactory(1))) {
    val tabs = listOf("Business", "Middle East","APAC")
    var tabIndex by remember { mutableStateOf(0) }

        Column(modifier = Modifier.fillMaxWidth()) {
            TabRow(selectedTabIndex = tabIndex) {
                tabs.forEachIndexed { index, title ->
                    Tab(text = { Text(title) },
                        selected = tabIndex == index,
                        onClick = { tabIndex = index }
                    )
                }
            }
            viewmodel.setNewsById(tabIndex)
            NewsListView(navHostController = navHostController, type = 0)





        }
}


