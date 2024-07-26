package com.example.mandiryapp.Network

import com.example.mandiryapp.Data.NewsResponse
import com.example.mandiryapp.Utils.Base
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApiService {
    @GET("top-headlines")
    suspend fun getTopHeadlines(
        @Query("Country") country: String,
        @Query("apiKey") apiKey: String = Base.API_KEY
    ): NewsResponse

    @GET("everything")
    suspend fun searchNews(
        @Query("q") query: String,
        @Query("apiKey")apiKey: String = Base.API_KEY
    ):NewsResponse
}