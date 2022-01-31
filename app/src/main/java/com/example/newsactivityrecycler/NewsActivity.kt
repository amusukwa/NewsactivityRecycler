package com.example.newsactivityrecycler

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.google.firebase.firestore.FirebaseFirestore

class NewsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news)
    }

    fun sendNews(view: android.view.View) {
        val db = FirebaseFirestore.getInstance()

        val headingtxt: TextView = findViewById<TextView>(R.id.heading)
        val subtitletxt: TextView = findViewById<TextView>(R.id.subtitle_text)

        val heading = headingtxt.text.toString()
        val subtitle = subtitletxt.text.toString()

        //adding data to firestore
        db.collection("mentors")

        val news:News = News(heading,subtitle)

    }
}