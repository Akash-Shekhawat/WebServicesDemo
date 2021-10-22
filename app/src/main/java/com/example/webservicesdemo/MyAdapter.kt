package com.example.webservicesdemo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyAdapter(val data: ArrayList<MyDataItem>): RecyclerView.Adapter<MyAdapter.ViewHolder>(){

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.rv_item_view, parent, false))
        }

        override fun getItemCount(): Int {
            return data.size
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            val item = data[position]
            holder.titleTextView.text= item.title
        }

        class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
            var titleTextView: TextView=itemView.findViewById(R.id.tv_home_item_title)

            var image: ImageView=itemView.findViewById(R.id.img_delete)

        }
}