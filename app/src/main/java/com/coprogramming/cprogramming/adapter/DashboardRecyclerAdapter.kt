package com.coprogramming.cprogramming.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.coprogramming.cprogramming.R
import com.coprogramming.cprogramming.model.Book
import com.coprogramming.cprogramming.myDashboardActivity.MainActivity1
import com.coprogramming.cprogramming.myDashboardActivity.MainActivity2
import com.coprogramming.cprogramming.myDashboardActivity.MainActivity3
import com.coprogramming.cprogramming.myDashboardActivity.MainActivity4


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

        holder.llContent.setOnClickListener {
            if (position == 0){
                val intent = Intent(context, MainActivity1::class.java)
                context.startActivity(intent)
            } else if (position == 1){
                context.startActivity(Intent(context,MainActivity2::class.java))
            } else if (position == 2){
                context.startActivity(Intent(context,MainActivity3::class.java))
            } else if ((position == 3)){
                context.startActivity(Intent(context,MainActivity4::class.java))
            } else {
                Toast.makeText(context, "Not Available", Toast.LENGTH_SHORT).show()
            }
        }
    }

    class DashboardViewHolder(view: View): RecyclerView.ViewHolder(view){
        val bookImage: ImageView = view.findViewById(R.id.imgImageView)
        val bookName: TextView = view.findViewById(R.id.txtBookName)
        val llContent: LinearLayout = view.findViewById(R.id.llContent)
    }

}