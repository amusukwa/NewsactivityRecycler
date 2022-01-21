package com.example.newsactivityrecycler

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
private  lateinit var recyclerview:recyclerview
private  lateinit var newsArray: ArrayList<News>
private  lateinit var imageId: ArrayList<Int>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        imageId = ArrayOf("R.drawable.ic_baseline_balance_24",
        "R.drawable.ic_baseline_account_circle_24"
        )

        heading = ArrayOf(" Account details for all users in the system",
"Buildings where users account information can be accessed")

recyclerview =  findViewById<Recylerview>(R.id.news_recycler)
recyclerview.layoutManager = LinearLayoutManager(this)
recyclerview.setHasFixedSize(true)
newsArray = arrayListOf<News>()

getNews()
    }

    fun getNews(){
        for (i in imageId.indices){
            val news = News(imageId[i].heading[i])
            newsArray.add(news)

        }
    }
}