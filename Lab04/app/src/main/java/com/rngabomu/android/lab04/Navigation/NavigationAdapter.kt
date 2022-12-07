package com.rngabomu.android.lab04.Navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.rngabomu.android.lab04.ui.screens.GroupScreenView
import com.rngabomu.android.lab04.ui.screens.HomeScreenView
import com.rngabomu.android.lab04.ui.screens.SettingScreenView


@Composable
fun Navigation(navController: NavHostController) {
    NavHost(navController, startDestination = NavigationItem.Home.route) {
        composable(NavigationItem.Home.route) {
            HomeScreenView()
        }
        composable(NavigationItem.Group.route) {
            GroupScreenView()
        }
        composable(NavigationItem.Setting.route) {
            SettingScreenView()
        }

    }
}
