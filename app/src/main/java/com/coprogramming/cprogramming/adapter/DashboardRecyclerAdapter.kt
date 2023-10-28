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
import androidx.recyclerview.widget.RecyclerView
import com.coprogramming.cprogramming.R
import com.coprogramming.cprogramming.model.Book
import com.coprogramming.cprogramming.myDashboardActivity.AbstractionActivity
import com.coprogramming.cprogramming.myDashboardActivity.ArrayActivity
import com.coprogramming.cprogramming.myDashboardActivity.ClassandObjectActivity
import com.coprogramming.cprogramming.myDashboardActivity.ConstructorActivity
import com.coprogramming.cprogramming.myDashboardActivity.EncapsulationActivity
import com.coprogramming.cprogramming.myDashboardActivity.ErrorExceptionActivity
import com.coprogramming.cprogramming.myDashboardActivity.InheritanceActivity
import com.coprogramming.cprogramming.myDashboardActivity.IntroductionActivity
import com.coprogramming.cprogramming.myDashboardActivity.LoopsActivity
import com.coprogramming.cprogramming.myDashboardActivity.PillarofOOPsActivity
import com.coprogramming.cprogramming.myDashboardActivity.PolymorphismActivity
import com.coprogramming.cprogramming.myDashboardActivity.StringActivity
import com.coprogramming.cprogramming.myDashboardActivity.VariableDataTypeActivity


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
            when(position){
                0-> context.startActivity(Intent(context, IntroductionActivity::class.java))
                1-> context.startActivity(Intent(context, VariableDataTypeActivity::class.java))
                2-> context.startActivity(Intent(context, ArrayActivity::class.java))
                3-> context.startActivity(Intent(context, StringActivity::class.java))
                4-> context.startActivity(Intent(context, LoopsActivity::class.java))
                5-> context.startActivity(Intent(context, ErrorExceptionActivity::class.java))
                6-> context.startActivity(Intent(context, ClassandObjectActivity::class.java))
                7-> context.startActivity(Intent(context, PillarofOOPsActivity::class.java))
                8-> context.startActivity(Intent(context, AbstractionActivity::class.java))
                9-> context.startActivity(Intent(context, EncapsulationActivity::class.java))
                10-> context.startActivity(Intent(context, InheritanceActivity::class.java))
                11-> context.startActivity(Intent(context, PolymorphismActivity::class.java))
                12-> context.startActivity(Intent(context, ConstructorActivity::class.java))

            }
        }
    }

    class DashboardViewHolder(view: View): RecyclerView.ViewHolder(view){
        val bookImage: ImageView = view.findViewById(R.id.imgImageView)
        val bookName: TextView = view.findViewById(R.id.txtBookName)
        val llContent: LinearLayout = view.findViewById(R.id.llContent)

    }

}