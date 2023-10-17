package com.coprogramming.cprogramming.adapter

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.coprogramming.cprogramming.R
import com.coprogramming.cprogramming.model.Book

class DashboardRecyclerAdapter(val context: Context, val itemList: ArrayList<Book>) : RecyclerView.Adapter<DashboardRecyclerAdapter.DashboardViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DashboardViewHolder {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onBindViewHolder(holder: DashboardViewHolder, position: Int) {
        val books = itemList[position]
        holder.txtBook.text = books.bookName
        holder.imgBook.setImageResource(books.bookImage)


    }

    class DashboardViewHolder(view: View): RecyclerView.ViewHolder(view){
        val imgBook: ImageView = view.findViewById(R.id.imgBook)
        val txtBook: TextView = view.findViewById(R.id.txtBook)

    }

}