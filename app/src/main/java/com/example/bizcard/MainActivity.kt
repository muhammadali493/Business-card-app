package com.example.bizcard

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.bizcard.ui.theme.BizCardTheme

private const val tag = "Button"
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BizCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    BizCard()
                }
            }
        }
    }
}

@Composable
fun BizCard(){
    val buttonClickedState = remember {
        mutableStateOf(false)
    }
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
    ) {
        Card(
            modifier = Modifier
                .width(200.dp)
                .height(390.dp)
                .padding(16.dp),
            shape = RoundedCornerShape(
                corner = CornerSize(32.dp)
            ),
            backgroundColor = Color.LightGray ,
            elevation = 8.dp,

        ) {
            Column(
                modifier = Modifier.height(300.dp),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                //Adding profile image
                ProfileImage()
                Divider(
                    color = Color.Black,
                    thickness = 4.dp,
                )
                Info()
                Button(
                    onClick = {
                        buttonClickedState.value = !buttonClickedState.value
                        Log.d(tag,"Button Clicked!!")
                    }
                ) {
                    Text(
                        text = "Portfolio",
                        style = MaterialTheme.typography.button
                    )
                }
                if (buttonClickedState.value){
                    Content()
                }else{
                    Box {
                        
                    }
                }
            }

        }
    }
}
@Preview
@Composable
fun Content(modifier: Modifier = Modifier){
    Box(
        modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(4.dp)
    ) {
        Surface(
            modifier
                .padding(4.dp)
                .fillMaxWidth()
                .fillMaxHeight(),
            shape = RoundedCornerShape(corner = CornerSize(8.dp)),
            border = BorderStroke(
                width = 3.dp,
                color = Color.Black
            )
        ) {
            Portfolio(
                data = listOf(
                "Project 1",
                "Project 2",
                "Project 3",
                "Project 4",
                "Project 5",
                "Project 6",
                "Project 7",
                "Project 5",
                "Project 5",
                "Project 5",
                "Project 5",
                "Project 5",
                "Project 5",
                "Project 5",
                "Project 5",
                "Project 5",
                "Project 5",
                "Project 5",
                "Project 5",
                "Project 5"
                )
            )
        }
    }
}

@Composable
fun Portfolio(data: List<String>) {
    LazyColumn {
        items(data){item: String ->
            Text(text = item)
        }
    }
}

@Composable
private fun Info() {
    Column(
        modifier = Modifier.padding(4.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(R.string.name),
            style = MaterialTheme.typography.h4,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colors.primaryVariant,
            modifier = Modifier.padding(4.dp)
        )
        Text(
            text = stringResource(R.string.title),
            style = MaterialTheme.typography.h5
        )
        Text(
            text = stringResource(R.string.email),
            style = MaterialTheme.typography.subtitle1
        )
    }
}

@Composable
private fun ProfileImage(modifier: Modifier = Modifier) {
    Surface(
        modifier = Modifier
            .size(160.dp)
            .padding(4.dp),
        shape = CircleShape,
        border = BorderStroke(0.5.dp, Color.DarkGray),
        elevation = 4.dp,
        color = MaterialTheme.colors.onSurface.copy(alpha = 0.35f)
    ) {
        Image(
            painter = painterResource(id = R.drawable.profile),
            contentDescription = "Profile image",
            modifier = Modifier.size(140.dp),
            contentScale = ContentScale.Crop
        )
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun DefaultPreview() {
    BizCardTheme {
        BizCard()
    }
}