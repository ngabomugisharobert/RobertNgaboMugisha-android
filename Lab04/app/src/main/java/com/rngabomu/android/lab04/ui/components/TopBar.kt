package com.rngabomu.android.lab04.ui.components

import android.widget.Toast
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.rngabomu.android.lab04.R

@Composable
fun TopBar() {
    TopAppBar(
        title = { Text(text = stringResource(id = R.string.top_bar ) , fontSize = 15.sp) },

        backgroundColor = Color.DarkGray,
        contentColor = Color.White
    )
}


@Preview(showBackground = true)
@Composable
fun BooksScreenPreview() {
    TopBar()
}
