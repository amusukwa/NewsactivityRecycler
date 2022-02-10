package com.example.newsactivityrecycler

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

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
        
// val docRef = db.collection("cities").document("BJ")
// docRef.get().addOnSuccessListener { documentSnapshot ->
//     val city = documentSnapshot.toObject<City>()
// }


    db = FirebaseFirestore.getInstance()
        db.collection("news").get().addSnapshotListener { value, error ->
            if (error != null) { }
            for (dc: DocumentChange in value?.documentChanges!!) {
                if (dc.type == DocumentChange.Type.ADDED) {
                    newsArray.add(dc.document.
                    toObject(News::class.java))

                }
            }
            recyclerview.adapter = MyAdapter(newsArray,this)
            adapter.notifyDataSetChanged()


}
        recyclerview.adapter = MyAdapter(newsArray,this)
    }

    override fun onItemClick(position: Int) {

        Toast.makeText(this,"Item clicked ",
            Toast.LENGTH_LONG).show()

    }

    fun sendActivity(view: android.view.View) {
        val intent = Intent(this,
            NewsActivity::class.java)
        startActivity(intent)
    }

}
