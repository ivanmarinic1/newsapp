package com.example.newsapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_desc.*

class news_desc : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.item_desc)
        getSupportActionBar()?.setDisplayHomeAsUpEnabled(true)

        val title = intent.getStringExtra("title")
        new_title.text = title

        val description = intent.getStringExtra("description")
        new_desc.text = description

        val author = intent.getStringExtra("author")
        new_author.text = "Author: " + author

        val image = intent.getStringExtra("image")
        Picasso.get()
            .load(image)
            .into(image_desc)
    }
}
