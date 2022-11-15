package com.rngabomu.android.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.rngabomu.android.myapplication.ui.theme.Lab02Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Lab02Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Column(
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        MainCompose()
                        }
                    }
                }
            }
        }
    }

    @Composable
    fun MainCompose() {

        //states for Comments
        var txtComment by remember { mutableStateOf("") }
        var completeTxtComment by remember {
            mutableStateOf("")
        }

        //states for image
        var toggle by remember { mutableStateOf(false) }
        var Logos by remember {
            mutableStateOf(
                if (toggle)
                    R.drawable.android1
                else
                    R.drawable.appstore
            )
        }


        Text(text = stringResource(id = R.string.app_name), textAlign = TextAlign.Center)


        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier
                    .background(MaterialTheme.colors.onBackground)
                    .padding(16.dp)
                    .fillMaxWidth()
                    .height(56.dp)
            ) {
                CommentTextField(name = txtComment, changed = { txtComment = it })
            }
            Img(Logos)

            CommentText(newComment = completeTxtComment)
            TxtOutput(comment = completeTxtComment)


            BtnChangeImage {
                completeTxtComment = txtComment
                toggle = !toggle
                Logos = if (toggle)
                    R.drawable.android1
                else
                    R.drawable.appstore
            }
        }
    }
@Composable
private fun AppBar() {
    TopAppBar(
        navigationIcon = {
            Icon(
                imageVector = Icons.Rounded.Menu,
                contentDescription = null,
                modifier = Modifier.padding(horizontal = 12.dp)
            )
        },
        title = {
            Text(text = stringResource(R.string.app_name))
        },
        backgroundColor = MaterialTheme.colors.primarySurface
    )
}

//a text field for user input
@Composable
fun CommentTextField(name: String, changed: (String) -> Unit) {
    Row() {
        TextField(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            value = name,
            onValueChange = changed,
            label = { Text(stringResource(id = R.string.placeholder))}
        )
    }
}

//a text composable for output
@Composable
fun TxtOutput(comment: String) {
    Text(text = stringResource(id = R.string.placeholder2)+" "+comment)
}

//an image composable
@Composable
fun Img(image:Int) {
    Image(
        painter = painterResource(id = image),
        contentDescription = stringResource(id = R.string.contentDescription),
        modifier = Modifier
            .padding(top = 40.dp, bottom = 40.dp)
            .size(150.dp)
            .clip(RoundedCornerShape(10.dp)),
        )
}

//a button that changes the image, and uses the input from the text field to change the output in the text composable
@Composable
fun BtnChangeImage(clicked: () -> Unit) {
    Button(onClick = clicked) {
        Text(stringResource(id = R.string.update))
    }
}


@Composable
fun CommentText(newComment: String){
    if(newComment.isNotEmpty()) {
        Text(
            "stringResource(R.string.MainCompose) $newComment",
            color = Color.White,
            textAlign = TextAlign.Center
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Lab02Theme {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            MainCompose()
        }
    }
}
