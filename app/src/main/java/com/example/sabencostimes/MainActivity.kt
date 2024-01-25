package com.example.sabencostimes

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement.Bottom
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.BottomAppBar
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.sabencostimes.domain.NYTNewsDataDomain
import com.example.sabencostimes.navigation.NavGraph
import com.example.sabencostimes.schema.BottomNavigationItem

import com.example.sabencostimes.ui.theme.SabencosTimes
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {

    @OptIn(ExperimentalFoundationApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SabencosTimes {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background

                ) {
                    val navController = rememberNavController()
                    val navBackStackEntry by navController.currentBackStackEntryAsState()
                    val currentRoute = navBackStackEntry?.destination?.route
                    val items = listOf(BottomNavigationItem.Dash,BottomNavigationItem.News,BottomNavigationItem.Newsletter,BottomNavigationItem.Settings)

                    Column() {
                        //Greeting("Business")
                        //Row(){

                        Log.v("url", BuildConfig.TIVV_URL.toString())

                        BottomNavigation (modifier = Modifier.align(alignment = Alignment.Start)){
                            items.forEachIndexed{index,item->
                                      BottomNavigationItem(
                                          selected = currentRoute == item.route,
                                          onClick = {
                                              //Toast.makeText(applicationContext,item.title,Toast.LENGTH_SHORT).show()
                                               navController.navigate(item.route){
                                                   popUpTo(navController.graph.findStartDestination().id) {
                                                       saveState = true
                                                   }
                                                   // Avoid multiple copies of the same destination when
                                                   // reselecting the same item
                                                   launchSingleTop = true
                                                   // Restore state when reselecting a previously selected item
                                                   restoreState = true
                                               }
                                               },
                                          icon = { Icon(painter = painterResource(id =item.icon ), contentDescription = item.title) })
                        }
                        }
                            NavGraph(navController = navController)

                    }

                }
            }
        }
    }
}


@Composable
fun Greeting(name: String) {






}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    SabencosTimes {
        Greeting("Android")
    }
}