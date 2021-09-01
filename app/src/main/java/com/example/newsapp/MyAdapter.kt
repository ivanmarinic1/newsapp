package com.example.newsapp

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_view.view.*


class MyAdapter(private val dataList: MutableList<Article>) : RecyclerView.Adapter<MyHolder>() {

    private lateinit var context: Context
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        context = parent.context
        return MyHolder(LayoutInflater.from(context).inflate(R.layout.item_view, parent, false))
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        val data= dataList[position]
        val newsTitleTextView = holder.itemView.newsTitle
        val newsImageView = holder.itemView.newsImage

        newsTitleTextView.text = "${data.title}"
        Picasso.get()
            .load(data.urlToImage)
            .into(newsImageView)

        holder.itemView.setOnClickListener {
            Toast.makeText(context, "${data.title}", Toast.LENGTH_SHORT).show()
            val intent = Intent(this.context, news_desc::class.java)
            intent.putExtra("title","${data.title}")
            intent.putExtra("author", "${data.author}")
            intent.putExtra("description","${data.description}")
            intent.putExtra("image","${data.urlToImage}")
            context.startActivity(intent)
        }

    }

    override fun getItemCount(): Int = dataList.size
}

