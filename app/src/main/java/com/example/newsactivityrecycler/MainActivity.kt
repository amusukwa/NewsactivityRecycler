package com.example.newsactivityrecycler

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.firestore.DocumentChange
import com.google.firebase.firestore.FirebaseFirestore

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerview: RecyclerView
    private lateinit var newsArray: ArrayList<News>
    private lateinit var imageId: Array<Int>
    private lateinit var heading: Array<String>


    override fun onCreate(
        savedInstanceState
        : Bundle?
    ) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        newsArray = arrayListOf<News>()

        imageId = arrayOf(R.drawable.a, R.drawable.b)

        heading = arrayOf<String>("Account details", "Office Building of the bank")

        recyclerview = findViewById<RecyclerView>(R.id.news_recycler)
        recyclerview.layoutManager = LinearLayoutManager(this)
        recyclerview.setHasFixedSize(true)
        var adapter = MyAdapter(newsArray)


        getNews()
    }

    private fun getNews() {


  val  db = FirebaseFirestore.getInstance()
        db.collection("News").addSnapshotListener { value, error ->
            if (error != null) { }
            for (dc: DocumentChange in value?.documentChanges!!) {
                if (dc.type == DocumentChange.Type.ADDED) {
                    newsArray.add(dc.document.
                    toObject(News::class.java))
                    Log.i("news", dc.document.toString())

                }
            }
            recyclerview.adapter = MyAdapter(newsArray)


}
//        val db = FirebaseFirestore.getInstance()
//        db.collection("News").get().addOnSuccessListener { documentSnapshot ->
//            val news = documentSnapshot.toObjects(News::class.java)
//            recyclerview.adapter = MyAdapter(newsArray, this)
//        }
//


//        fun sendActivity(view: android.view.View) {
//
//        }
//
//    }


}

    fun sendActivity(view: android.view.View) {
        val intent = Intent(
                this,
                NewsActivity::class.java
            )
            startActivity(intent)

    }
}
