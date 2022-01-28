package com.example.newsactivityrecycler

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.google.firebase.firestore.FirebaseFirestore

class NextActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_next)
    }

    fun sendNews(view: android.view.View) {

        val db = FirebaseFirestore.getInstance()

        val subtitletxt: TextView = findViewById<TextView>(R.id.subtitle_text)
        val headingtxt: TextView = findViewById<TextView>(R.id.heading)

        val subtitle = subtitletxt.text.toString()
        val heading = headingtxt.text.toString()

        //adding data to firestore
        db.collection("mentors")

        val news:News = News(subtitle,heading)

        val newsRef = db.collection("mentors").add(news)

    }
}