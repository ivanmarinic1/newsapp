package com.example.newsapp

data class Data(
    val articles: List<Article>,
    val sortBy: String,
    val source: String,
    val status: String
)