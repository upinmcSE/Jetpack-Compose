# Everything about Text in Jetpack Compose

## Content
- Display Text
    - String
    - Resouce String

- Text Color
- Text Size
- FontStyle
- FontWeight
- Text Alignment
- FontFamily
- Text overflow
- Text decoration
- MaximumLines
- Multiple Styles in Text
    - SpanStyle
    - ParagraphStyle

```kotlin
package com.example.app2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
    Column {
        GreetingText(name = "Upin")
        GreetingText2()
        Spacer(modifier = Modifier.height(10.dp))
        MultipleStylesText()
    }
}

// String parameter
@Composable
fun GreetingText(name: String) {
    Text(
        text = "Hello $name!",
        color = Color.Red,
        fontSize = 30.sp,
        fontWeight = FontWeight.Bold,
        textAlign = TextAlign.Right,
        modifier = Modifier.fillMaxWidth()
    )
}
// String resource
@Composable
fun GreetingText2() {
    Text(
        text = stringResource(id = R.string.app_name),
        color = Color.Blue,
        fontStyle = FontStyle.Italic,
        textAlign = TextAlign.Center,
        modifier = Modifier.fillMaxWidth(),
        textDecoration = TextDecoration.LineThrough,
        maxLines = 2, // Limit the number of lines
        overflow = TextOverflow.Ellipsis // Add ellipsis when text is overflow
    )
}

// Multiple styles
@Composable
fun MultipleStylesText(){
    // SpanStyle is used to apply different styles to different parts of the text
    Text(text = buildAnnotatedString {
        withStyle(style = SpanStyle(color = Color.Red)) {
            append("H")
        }
        append("ello ")
        withStyle(style = SpanStyle(color = Color.Blue)) {
            append("U")
        }
        append("pin")
    })
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    App2Theme {
        HomeScreen()
    }
}

```
