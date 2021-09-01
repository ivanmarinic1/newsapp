package com.example.newsapp

data class Article(
    val author: String,
    val description: String,
    val publishedAt: Any,
    val title: String,
    val url: String,
    val urlToImage: String
)