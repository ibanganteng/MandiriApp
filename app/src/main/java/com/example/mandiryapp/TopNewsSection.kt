package com.example.mandiryapp



import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.mandiryapp.Data.Article
import com.google.gson.Gson
import java.net.URLEncoder
import java.nio.charset.StandardCharsets

@Composable
fun TopNewsSection(article: Article, navController: NavController) {
    Column(
        modifier = Modifier
            .padding(16.dp)
            .clickable {
                val articleJson = URLEncoder.encode(Gson().toJson(article), StandardCharsets.UTF_8.toString())
                navController.navigate("articleDetail/$articleJson")
            }
    ) {
        Text(
            text = "Berita Terkini",
            color = colorResource(id = R.color.mandiri),
            fontWeight = FontWeight.ExtraBold,
            fontSize = 20.sp,
            modifier = Modifier.padding(bottom = 8.dp)
        )
        Card(
            elevation = 4.dp,
            modifier = Modifier.fillMaxWidth()
        ) {
            Column {
                AsyncImage(
                    model = article.urlToImage,
                    contentDescription = article.title,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .height(200.dp)
                        .fillMaxWidth()
                )
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(text = article.title, style = MaterialTheme.typography.h6)
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(text = article.description ?: "No description", style = MaterialTheme.typography.body2)
                }
            }
        }
    }
}
