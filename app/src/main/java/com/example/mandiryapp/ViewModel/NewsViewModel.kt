package com.example.mandiryapp.ViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mandiryapp.Data.Article
import com.example.mandiryapp.Network.RetrofitInstance
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class NewsViewModel : ViewModel() {
    private val _news = MutableStateFlow<List<Article>>(emptyList())
    val news: StateFlow<List<Article>> = _news

    private val _topHeadlines = MutableStateFlow<List<Article>>(emptyList())
    val topHeadlines: StateFlow<List<Article>> = _topHeadlines

    init {
        fetchTopHeadlines()
    }

    fun fetchTopHeadlines() {
        viewModelScope.launch {
            val response = RetrofitInstance.api.getTopHeadlines("us")
            _topHeadlines.value = response.articles
            _news.value = response.articles
        }
    }

    fun searchNews(query: String) {
        viewModelScope.launch {
            val response = RetrofitInstance.api.searchNews(query)
            _news.value = response.articles
        }
    }
}
