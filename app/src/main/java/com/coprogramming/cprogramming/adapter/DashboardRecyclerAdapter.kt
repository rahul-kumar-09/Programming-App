package com.coprogramming.cprogramming.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.coprogramming.cprogramming.R
import com.coprogramming.cprogramming.model.Book


class DashboardRecyclerAdapter(val context: Context, val itemList: ArrayList<Book>): RecyclerView.Adapter<DashboardRecyclerAdapter.DashboardViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DashboardViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recycler_single_book_item, parent, false)
        return DashboardViewHolder(view)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onBindViewHolder(holder: DashboardViewHolder, position: Int) {
        val book = itemList[position]
        holder.bookName.text = book.bookName
        holder.bookImage.setImageResource(book.bookImage)
    }

    class DashboardViewHolder(view: View): RecyclerView.ViewHolder(view){
        val bookImage: ImageView = view.findViewById(R.id.imgImageView)
        val bookName: TextView = view.findViewById(R.id.txtBookName)
    }

}