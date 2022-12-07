package com.rngabomu.android.lab04.Navigation

import com.rngabomu.android.lab04.R


sealed class NavigationItem(var route:String,var icon:Int, var title:String){
    object Home: NavigationItem("home", R.drawable.ic_baseline_home_24,"Home")
    object Group: NavigationItem("group", R.drawable.ic_baseline_group_24,"Group")
    object Setting: NavigationItem("setting", R.drawable.ic_baseline_settings_24,"Setting")
}
