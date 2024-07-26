package com.example.mandiryapp.View

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.mandiryapp.ArticleItem
import com.example.mandiryapp.R
import com.example.mandiryapp.TopNewsSection
import com.example.mandiryapp.ViewModel.NewsViewModel
import com.google.gson.Gson
import java.net.URLEncoder
import java.nio.charset.StandardCharsets

@Composable
fun NewsScreen(navController: NavController, newsViewModel: NewsViewModel = viewModel()) {
    val news by newsViewModel.news.collectAsState()
    val topHeadlines by newsViewModel.topHeadlines.collectAsState()
    var searchQuery by remember { mutableStateOf("") }
    val focusManager = LocalFocusManager.current

    Scaffold(
        topBar = {

            TopAppBar(
                title = { Text("Mandiri News") },
                backgroundColor = colorResource(id = R.color.mandiri),
                contentColor = Color.White
            )
        }
    ) { padding ->
        Column(modifier = Modifier
            .padding(padding)
            .clickable { focusManager.clearFocus() }) {
            OutlinedTextField(
                value = searchQuery,
                onValueChange = {
                    searchQuery = it
                },
                label = { Text("Search") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            )
            Button(
                onClick = {
                    if (searchQuery.isNotEmpty()) {
                        newsViewModel.searchNews(searchQuery)
                        focusManager.clearFocus()
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                    colors = ButtonDefaults.buttonColors(colorResource(id = R.color.mandiri))
            ) {
                Text("Search", color = Color.White)
            }
            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(8.dp),
                modifier = Modifier.fillMaxSize()
            ) {
                item {
                    if (topHeadlines.isNotEmpty()) {
                        TopNewsSection(topHeadlines.random(), navController)
                    }
                }
                item {
                    Text(
                        text = "Semua Berita",
                        color = colorResource(id = R.color.mandiri),
                        fontWeight = FontWeight.ExtraBold,
                        fontSize = 20.sp,
                        modifier = Modifier.padding(16.dp)
                    )
                }
                items(news) { article ->
                    ArticleItem(article) {
                        val articleJson = URLEncoder.encode(Gson().toJson(article), StandardCharsets.UTF_8.toString())
                        navController.navigate("articleDetail/$articleJson")
                    }
                }
            }
        }
    }
}
