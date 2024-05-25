package com.example.parallaxeffectcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.parallaxeffectcompose.ui.theme.ParallaxEffectComposeTheme
import com.example.parallaxeffectcompose.ui.theme.Purple40
import java.lang.Float.min

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ParallaxEffectComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                    Parrallx()
                }
            }
        }
    }
}

@Composable
fun Parrallx(){
    val scrollState = rememberScrollState()
    Box{
        Column(modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState)) {
            
            Box(modifier = Modifier
                .fillMaxWidth()
                .height(500.dp)
                .graphicsLayer {
                    alpha = 1f - (scrollState.value.toFloat() / scrollState.maxValue)
                    translationY = 0.5f * scrollState.value
                }, contentAlignment = Alignment.Center
            ) {
                Image(painter = painterResource(id = R.drawable.king_kohli)
                    ,contentDescription = null,
                    contentScale = ContentScale.Crop, modifier = Modifier.fillMaxSize())
            }
            
            Text(text = stringResource(id = R.string.title),
                style = MaterialTheme.typography.headlineMedium,
                modifier = Modifier.padding(horizontal = 8.dp, vertical = 8.dp))
            
            Text(text = stringResource(id = R.string.desc),
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp))

        }

        Box(modifier = Modifier
            .fillMaxWidth()
            .height(55.dp) .graphicsLayer {
                alpha = min(1f, (scrollState.value.toFloat() / scrollState.maxValue))
            }.background(color = Purple40), contentAlignment = Alignment.CenterStart){
            Text(text = "Header", style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.padding(horizontal = 12.dp), color = Color.White)
        }
    }
}






















