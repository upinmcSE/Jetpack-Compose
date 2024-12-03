package com.example.app2

import androidx.compose.ui.graphics.Color
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.app2.ui.theme.App2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            App2Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxWidth(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    HomeScreen()
                }
            }
        }
    }
}

@Composable
fun HomeScreen(){
    Column(modifier = Modifier.padding(24.dp)) {
        SimpleButton()
        CommonSpace()
        DisableSimpleButton()
        CommonSpace()
        RoundedCornerButton()
        CommonSpace()
        BorderSimpleButton()
        CommonSpace()
        ElevationSimpleButton()
        CommonSpace()
        OutlinedButton(onClick = { /*TODO*/ }) {
            Text(text ="Outlined Button")
        }
        CommonSpace()
        TextButton(onClick = { /*TODO*/ }) {
            Text(text = "Text Button", style = TextStyle(color = Color.Red))
        }
        CommonSpace()
        IconButton(onClick = { /*TODO*/ }) {
            Icon(Icons.Default.ShoppingCart, contentDescription = null)
        }
    }
}

@Composable
fun SimpleButton(){
    val count = remember {
        mutableStateOf(0)
    }
    Column {
        Button(
            onClick = {
                      count.value += 1
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Red,
                contentColor = Color.Green
            )
        ){
            Icon(Icons.Default.ShoppingCart, contentDescription = null)
            Text(text = "Add to cart", style = TextStyle(color = Color.Yellow))
        }
        Text(text = " Cart: ${count.value}", style = TextStyle(color = Color.Black))
    }

}

@Composable
fun DisableSimpleButton(){
    Button(
        onClick = {},
        colors = ButtonDefaults.buttonColors(
            disabledContainerColor = Color.Black,
            disabledContentColor = Color.Yellow
        ),
        enabled = false
    ){
        Text(text = "Disable Button")
    }
}

@Composable
fun RoundedCornerButton(){
    Button(
        onClick = {},
        shape = RoundedCornerShape(bottomEnd = 14.dp, topEnd = 14.dp, bottomStart = 14.dp),
        ) {
        Text(text ="Rounded Corner Button")
    }
}

@Composable
fun BorderSimpleButton(){
    Button(
        onClick = { /*TODO*/ },
        border = BorderStroke(width = 2.dp, color = Color.Magenta),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.White,
        ),
        shape = RoundedCornerShape(13.dp)

    ) {
        Text(text = "Check out", style = TextStyle(color = Color.Magenta))
    }
}


@Composable
fun ElevationSimpleButton(){
    Button(
        onClick = {},
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.White,
        ),
        elevation = ButtonDefaults.buttonElevation(
            defaultElevation = 8.dp,
            pressedElevation = 16.dp,
            disabledElevation = 0.dp
        )
    ){
        Text(text = "Text", style = TextStyle(color = Color.Black))
    }
}


@Composable
fun CommonSpace(){
    Spacer(modifier = Modifier.height(24.dp))
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    App2Theme {
        HomeScreen()
    }
}