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
        Book("Introduction",R.drawable.basic),
        Book("Variable & Data Type", R.drawable.datatype),
        Book("Array",R.drawable.array),
        Book("String",R.drawable.characters),
        Book("Loop",R.drawable.loop),
        Book("Error & Exception",R.drawable.errors),
        Book("Class and Object", R.drawable.classes),
        Book("Pillar of OOPs", R.drawable.pillar),
        Book("Abstraction", R.drawable.abstraction),
        Book("Encapsulation", R.drawable.capsule),
        Book("Inheritance", R.drawable.inheritance),
        Book("Polymorphism", R.drawable.arrows),
        Book("Constructor",R.drawable.constructors),

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