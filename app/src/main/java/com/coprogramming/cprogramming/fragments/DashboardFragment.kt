package com.coprogramming.cprogramming.fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.coprogramming.cprogramming.R
import com.coprogramming.cprogramming.adapter.DashboardRecyclerAdapter
import com.coprogramming.cprogramming.model.Book

class DashboardFragment : Fragment() {
    private lateinit var dashboardRecycler: RecyclerView
    private lateinit var layoutManager: RecyclerView.LayoutManager
    private lateinit var recyclerAdapter: DashboardRecyclerAdapter


    val bookListInfo = arrayListOf<Book>(
        Book("1",R.drawable.basic),
        Book("1", R.drawable.variable),
        Book("2", R.drawable.datatype),
        Book("3",R.drawable.array),
        Book("4",R.drawable.characters),
        Book("4",R.drawable.loop),
        Book("5",R.drawable.errors),
        Book("6", R.drawable.classes),
        Book("7", R.drawable.onject),
        Book("8", R.drawable.inheritance),
        Book("9",R.drawable.constructors),

        )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_dashboard, container, false)

        dashboardRecycler = view.findViewById(R.id.dashboard_recycler)
        layoutManager = LinearLayoutManager(activity)
        recyclerAdapter = DashboardRecyclerAdapter(activity as Context, bookListInfo)
        dashboardRecycler.adapter = recyclerAdapter
        dashboardRecycler.layoutManager = layoutManager

        return view
    }

}