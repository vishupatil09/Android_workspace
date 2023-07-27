package com.example.recycleview

import MyAdapter
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recycleview.R

class MainActivity : AppCompatActivity() {

    lateinit var recyclerView: RecyclerView
    lateinit var dataList :MutableList<String>

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)
        dataList = ArrayList<String>()


        //var recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        var layoutmanager:RecyclerView.LayoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutmanager



        for (i in 1..20)
        {
            dataList.add("Item $i")
        }

        var adapter = MyAdapter(dataList)
        recyclerView.adapter = adapter
    }
}
