package com.example.newsactivityrecycler

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.newsactivityrecycler.R.drawable.*

class MainActivity : AppCompatActivity(),MyAdapter.OnItemClicklistener{
    private lateinit var recyclerview: RecyclerView
    private lateinit var newsArray: ArrayList<News>
    private lateinit var imageId: Array<Int>
    private lateinit var heading: Array<String>


    override fun onCreate(savedInstanceState
                          : Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        newsArray = arrayListOf<News>()

        imageId = arrayOf(R.drawable.a,R.drawable.b)

        heading = arrayOf<String>("Account details","Office Building of the bank")

        recyclerview = findViewById<RecyclerView>(R.id.news_recycler)
        recyclerview.layoutManager = LinearLayoutManager(this)
        recyclerview.setHasFixedSize(true)
        var adapter = MyAdapter(newsArray,this)


        getNews()
    }

    private fun getNews() {
//        for (i in imageId.indices) {
//            val news = News(imageId[i], heading[i])
//            newsArray.add(news)
//
//        }
        recyclerview.adapter = MyAdapter(newsArray,this)
    }

    override fun onItemClick(position: Int) {

        val intent = Intent(this,
            NextActivity::class.java)
        startActivity(intent)
        Toast.makeText(this,"Item clicked ",
            Toast.LENGTH_LONG).show()

    }

}
