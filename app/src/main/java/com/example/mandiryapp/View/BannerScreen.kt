package com.example.mandiryapp.View

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.mandiryapp.R


@Composable
fun BannerScreen(navController: NavHostController) {
    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.ridwan),
            contentDescription = null,
            modifier = Modifier
                .fillMaxSize()
                .size(90.dp),
            contentScale = ContentScale.Crop
        )
        Column(
            modifier = Modifier
                .wrapContentHeight()
                .align(Alignment.BottomCenter)
                .background(
                    color = Color.White.copy(alpha = 0.4f),
                    shape = RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp)
                )
                .border(
                    BorderStroke(0.5.dp, Color.White),
                    shape = RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp)
                ),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Enjoy The World of News",
                modifier = Modifier.padding(vertical = 25.dp),
                fontWeight = FontWeight.Bold,
                color = colorResource(id = R.color.mandiri)
            )


            OutlinedButton(
                onClick = { navController.navigate("newList") },
                modifier = Modifier
                    .padding(bottom = 55.dp, start = 20.dp, end = 20.dp)
                    .fillMaxWidth()
                    .border(BorderStroke(5.dp, color = colorResource(id = R.color.mandiri)), shape = RoundedCornerShape(30.dp))

            ) {
                Text(
                    text = "Masuk",
                    modifier = Modifier.padding(vertical = 25.dp),
                    fontWeight = FontWeight.ExtraBold,
                    color = colorResource(id = R.color.mandiri)
                )
            }
        }
    }
}
