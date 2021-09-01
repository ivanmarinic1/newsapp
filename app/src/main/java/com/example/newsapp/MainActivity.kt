package com.example.newsapp

import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.OrientationHelper
import com.androidnetworking.AndroidNetworking
import com.androidnetworking.error.ANError
import com.androidnetworking.interfaces.ParsedRequestListener
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val dataList: MutableList<Article> = mutableListOf()
    private lateinit var myAdapter: MyAdapter
    lateinit var progressBar: ProgressBar


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        progressBar = findViewById(R.id.progressBar)

        myAdapter = MyAdapter(dataList)

        recycler_view.layoutManager=LinearLayoutManager(this)
        recycler_view.addItemDecoration(DividerItemDecoration(this, OrientationHelper.VERTICAL))
        recycler_view.adapter = myAdapter


        AndroidNetworking.initialize(this)

        AndroidNetworking.get("https://newsapi.org/v1/articles?source=bbc-news&sortBy=top&apiKey=6946d0c07a1c4555a4186bfcade76398")
            .build()
            .getAsObject(Data::class.java, object : ParsedRequestListener<Data> {
                override fun onResponse(response: Data) {
                    dataList.addAll(response.articles)
                    myAdapter.notifyDataSetChanged()
                    progressBar.visibility = View.GONE
                }

                override fun onError(anError: ANError?) {
                    Toast.makeText(this@MainActivity, "Doslo je do pogreške", Toast.LENGTH_SHORT).show()
                }
            })


    }


}
