# Image

## Content
- Display image painter Resource
- Display image vector Resource
- Display image bitmap
- Display from Url
- ContentScale
    - Fit
    - Crop
    - Inside
    - FillHeight
    - FullWidth
    - FillBound
- aliment
- contentDesciption
- modify Clip
- modify Shadow
- Image with Surface
    - Circle 
    - RoundedCornerShape
    - Border
    - aspect Ratio
-Icon




```kotlin
package com.example.app2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.rememberAsyncImagePainter
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
    Column(modifier = Modifier.padding(16.dp)) {
        BannerResource(contentScale = ContentScale.Crop)
        Spacer(modifier = Modifier.padding(16.dp))
//        BannerPantingResource(contentScale = ContentScale.Fit)
//        Spacer(modifier = Modifier.padding(16.dp))
//        BannerPantingResource(contentScale = ContentScale.Inside)
//        Spacer(modifier = Modifier.padding(16.dp))

        VectorImageResource()
        Spacer(modifier = Modifier.padding(16.dp))

        CircleAvatar()
        Spacer(modifier = Modifier.padding(16.dp))

        ImageFromUrl()


    }
}

// Image bitmap Resource
@Composable
fun BannerResource(contentScale: ContentScale){
    Image(
        painterResource(id = R.drawable.banner1),
        contentDescription = "Banner1",
        contentScale = contentScale,
        modifier = Modifier
            .height(150.dp)
            .fillMaxWidth()
            .shadow(
                elevation = 10.dp,
                shape = RoundedCornerShape(10.dp)
            ),
    )
}

// Image vector
@Composable
fun VectorImageResource(){
    Image(imageVector = Icons.Filled.Person, contentDescription = "Banner2")
}

// Custom Painter

// Circle Image
@Composable
fun CircleAvatar(){
    Surface (
        modifier = Modifier
            .size(150.dp)
            .border(BorderStroke(2.dp, Color.Gray), shape = CircleShape)
            .clip(shape = CircleShape)
    ){
        Image(
            painterResource(id = R.drawable.anh_the_2),
            contentDescription = "Avatar",
            contentScale = ContentScale.Inside,
        )
    }
}

// Display image from Url
@Composable
fun ImageFromUrl(){
    rememberAsyncImagePainter(
        model = "https://images.pexels.com/photos/276267/pexels-photo-276267.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",)
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    App2Theme {
        HomeScreen()
    }
}


```
## Tham Khao:   
https://medium.com/mobile-app-development-publication/loading-image-in-android-jetpack-compose-made-easy-8cb593b26260