package com.rngabomu.android.lab04.ui.components

import android.widget.Toast
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp

@Composable
fun TopBar() {
    TopAppBar(
        title = { Text(text = "Bottom Navbar", fontSize = 15.sp) },
        backgroundColor = Color.DarkGray,
        contentColor = Color.White
    )
}

@Composable
fun CustomBackButton() {
    Button(
//        add an icon to this button

        onClick = {

            // Handle navigating back

        },

        // Other attributes...
    ) {
        // Button content, such as an icon or text
    }
}

@Preview(showBackground = true)
@Composable
fun BooksScreenPreview() {
    TopBar()
}
