package com.example.newsactivityrecycler

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase

class NewsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news)
    }

    fun sendNews(view: android.view.View) {
        val db = FirebaseFirestore.getInstance()
        // Write a message to the database
        val database = FirebaseDatabase.getInstance()
        val myRef = database.getReference("news")

        myRef.setValue("Hello, World!")

        val headingtxt: TextView = findViewById<TextView>(R.id.heading)
        val subtitletxt: TextView = findViewById<TextView>(R.id.proficiency_edit)

        val heading = headingtxt.text.toString()
        val subtitle = subtitletxt.text.toString()

        val news:News = News(heading,subtitle)

        //adding data to firestore
        db.collection("News").add(news)
        Toast.makeText(this,"added",Toast.LENGTH_SHORT).show()
    }
}