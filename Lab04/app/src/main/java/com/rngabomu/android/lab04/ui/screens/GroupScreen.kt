package com.rngabomu.android.lab04.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun GroupScreenView() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .wrapContentSize(Alignment.Center)
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(15.dp)
                .clickable { },
            elevation = 10.dp
        ) {
            Column(
                modifier = Modifier.padding(15.dp)
            ) {
                Text(
                    buildAnnotatedString {
                        withStyle(style = SpanStyle(fontWeight = FontWeight.W900, color = Color(0xFF4552B6),fontSize = 20.sp)
                        ) {
                            append(stringResource(id = com.rngabomu.android.lab04.R.string.welcome_to_group))
                        }
                    }
                )
                Text(
                    buildAnnotatedString {
                        append(stringResource(id = com.rngabomu.android.lab04.R.string.now_you_are_in_the))
                        withStyle(style = SpanStyle(fontWeight = FontWeight.W900, color = Color(0xFF4552B6),fontSize = 20.sp)) {
                            append(stringResource(id = com.rngabomu.android.lab04.R.string.group))
                        }

                    }
                )
            }
        }

    }
}
