package com.example.mandiryapp.Navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.mandiryapp.Data.Article
import com.example.mandiryapp.View.BannerScreen
import com.example.mandiryapp.View.DetailScreen
import com.example.mandiryapp.View.NewsScreen
import com.google.gson.Gson
import java.net.URLDecoder
import java.nio.charset.StandardCharsets


@Composable
fun NewsApp() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "banner" ){
        composable("banner"){
            BannerScreen(navController = navController)
        }
        composable("newList"){
            NewsScreen(navController = navController)
        }
        composable(route="articleDetail/{articleJson}",
            arguments = listOf(navArgument("articleJson"){type = NavType.StringType})
            ){backStackEntry ->
            val articleJson = backStackEntry.arguments?.getString("articleJson")
            val articleJsonDecoded = URLDecoder.decode(articleJson,StandardCharsets.UTF_8.toString())
            val article = Gson().fromJson(articleJsonDecoded,Article::class.java)
            DetailScreen(article)

        }
    }
}