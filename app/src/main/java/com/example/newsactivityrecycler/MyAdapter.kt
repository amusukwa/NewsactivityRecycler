package com.example.newsactivityrecycler

import android.content.DialogInterface
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyAdapter(private val newsArray:ArrayList<News>
, private val listener:OnItemClicklistener)
    : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

  interface OnItemClicklistener{
    fun onItemClick(position: Int)
}
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyAdapter.MyViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item,parent,false)
        return MyViewHolder(itemView as ViewGroup)
    }

    override fun onBindViewHolder(holder: MyAdapter.MyViewHolder, position: Int) {
        val news:News = newsArray[position]
        holder.subtitle.text = news.subtitle
        holder.heading.text = news.heading

    }

    override fun getItemCount(): Int {
        return newsArray.size
    }

    inner class MyViewHolder(itemView : ViewGroup):RecyclerView.ViewHolder(itemView), View.OnClickListener {
        val subtitle: TextView = itemView.findViewById(R.id.subtitle_text)
        val heading: TextView = itemView.findViewById(R.id.heading)

        init{
            itemView.setOnClickListener(this)
        }



        override fun onClick(p0: View?) {
            val position:Int = adapterPosition
            if (position != RecyclerView.NO_POSITION){
                listener.onItemClick(position)

            }
        }
    }
}